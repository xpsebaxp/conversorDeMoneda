import com.google.gson.Gson;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaMoneda {
    String monedaPuntero;
    public Moneda buscaMoneda(String monedaPuntero) {
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/4a340f6334b6b7dc4aa154bb/latest/"+monedaPuntero);
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(String.valueOf(direccion)))
                .build();

        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), Moneda.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
    public String convertirMoneda(int opcion, double cantidad, String monedaPuntero){
        String conversion = "";
        ConsultaMoneda consulta = new ConsultaMoneda();
        Moneda moneda = consulta.buscaMoneda(monedaPuntero);


        if(opcion == 1){
            Double monedaARG = moneda.getConversionRate("ARS");
            conversion = String.valueOf((monedaARG*cantidad));
            return "El valor "+cantidad+" [USD] corresponde al valor final de =>>> "+conversion+"[ARS]";
        } else if (opcion == 2){
            Double monedaUSD= moneda.getConversionRate("USD");
            conversion = String.valueOf((monedaUSD*cantidad));
            return "El valor "+cantidad+" [ARS] corresponde al valor final de =>>> "+conversion+"[USD]";
        } else if (opcion == 3) {
            Double monedaBRL= moneda.getConversionRate("BRL");
            conversion = String.valueOf((monedaBRL*cantidad));
            return "El valor "+cantidad+" [USD] corresponde al valor final de =>>> "+conversion+"[BRL]";
        } else if (opcion == 4) {
            Double monedaUSD= moneda.getConversionRate("USD");
            conversion = String.valueOf((monedaUSD*cantidad));
            return "El valor "+cantidad+" [BRL] corresponde al valor final de =>>> "+conversion+"[USD]";
        } else if (opcion == 5) {
            Double monedaCOP= moneda.getConversionRate("COP");
            conversion = String.valueOf((monedaCOP*cantidad));
            return "El valor "+cantidad+" [USD] corresponde al valor final de =>>> "+conversion+"[COP]";
        } else if (opcion == 6) {
            Double monedaUSD = moneda.getConversionRate("USD");
            conversion = String.valueOf((monedaUSD * cantidad));
            return "El valor " + cantidad + " [COP] corresponde al valor final de =>>> " + conversion + "[USD]";
        }
        return conversion;
    }


}
