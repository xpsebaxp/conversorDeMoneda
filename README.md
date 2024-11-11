
# Conversor de Monedas

Este proyecto es una aplicación de conversión de monedas desarrollada en Java que permite consultar y convertir entre diferentes monedas en tiempo real mediante una API externa. La interfaz de usuario es de línea de comandos, donde el usuario puede seleccionar opciones de conversión específicas entre monedas como USD, ARS, BRL y COP.

## Estructura del Proyecto

El proyecto contiene las siguientes clases:

- **Moneda.java**: Representa una moneda con sus tasas de conversión hacia otras monedas. Utiliza un mapa (`Map<String, Double>`) para almacenar las tasas y proporciona el método `getConversionRate` para obtener la tasa de cambio hacia una moneda específica.

  ```java
  import java.util.Map;

  public record Moneda(Map<String, Double> conversion_rates) {
      public Double getConversionRate(String monedaObjetivo){
          return conversion_rates.get(monedaObjetivo);
      }
  }
  ```

- **ConsultaMoneda.java**: Realiza solicitudes HTTP a la API de ExchangeRate para obtener datos de conversión en tiempo real. Usa `HttpClient` para hacer una solicitud GET, deserializa la respuesta JSON usando `Gson` y convierte los datos en un objeto `Moneda`. Además, incluye el método `convertirMoneda` para realizar conversiones específicas basadas en la moneda y cantidad ingresadas.

  ```java
  import com.google.gson.Gson;
  import java.io.IOException;
  import java.net.URI;
  import java.net.http.HttpClient;
  import java.net.http.HttpRequest;
  import java.net.http.HttpResponse;

  public class ConsultaMoneda {
      public Moneda buscaMoneda(String monedaPuntero) {
          URI direccion = URI.create("https://v6.exchangerate-api.com/v6/YOUR_API_KEY/latest/" + monedaPuntero);
          HttpClient client = HttpClient.newHttpClient();

          HttpRequest request = HttpRequest.newBuilder()
                  .uri(URI.create(String.valueOf(direccion)))
                  .build();

          try {
              HttpResponse<String> response = client
                      .send(request, HttpResponse.BodyHandlers.ofString());
              return new Gson().fromJson(response.body(), Moneda.class);
          } catch (IOException | InterruptedException e) {
              throw new RuntimeException(e);
          }
      }

      public String convertirMoneda(int opcion, double cantidad, String monedaPuntero) {
          // Conversión específica basada en la opción
          // Retorna el resultado formateado como cadena
      }
  }
  ```

- **Principal.java**: Clase principal que maneja la interfaz de usuario de línea de comandos. Presenta un menú interactivo donde el usuario puede seleccionar opciones para convertir entre distintas monedas. Basado en la opción seleccionada, `Principal` llama al método `convertirMoneda` de `ConsultaMoneda` y muestra el resultado al usuario.

  ```java
  import java.util.Scanner;

  public class Principal {
      public static void main(String[] args) {
          // Lógica de menú interactivo
          // Selección de opciones de conversión
      }
  }
  ```

## Archivos

- `Moneda.java`: Define la clase `Moneda`, que almacena las tasas de conversión en un mapa.
- `ConsultaMoneda.java`: Maneja las solicitudes HTTP a la API de ExchangeRate y realiza las conversiones.
- `Principal.java`: Contiene la interfaz de usuario y permite la interacción para realizar conversiones.
- `ConversorDeMonedas.iml`: Archivo de configuración del proyecto para IDE.
- Archivos `.class`: Archivos compilados de las clases en Java.

## Requisitos

- **Java JDK** 11 o superior
- **Biblioteca Gson** (para manejar JSON)
- **API Key de ExchangeRate** (reemplaza `YOUR_API_KEY` en el código con tu clave de API)
- **IDE** (opcional, recomendado IntelliJ IDEA)

## Cómo Usar

1. Clona el repositorio en tu máquina local:
   ```bash
   git clone https://github.com/tu_usuario/conversor-de-monedas.git
   ```
2. Agrega tu clave de API en `ConsultaMoneda.java`.
3. Compila los archivos Java:
   ```bash
   javac src/*.java
   ```
4. Ejecuta la aplicación desde la clase principal:
   ```bash
   java src/Principal
   ```

## Ejemplo de Uso

Al iniciar la aplicación, se mostrará el siguiente menú en la consola:

```
**************************************************

1) Dólar =>> Peso argentino
2) Peso argentino =>> Dólar
3) Dólar =>> Real brasileño
4) Real brasileño =>> Dólar
5) Dólar =>> Peso colombiano
6) Peso colombiano =>> Dólar
7) Salir
Elija una opción válida:

**************************************************
```

1. Selecciona la opción de conversión deseada.
2. Ingresa la cantidad que deseas convertir.
3. La aplicación muestra el resultado en tiempo real utilizando las tasas de cambio obtenidas de la API.


---
