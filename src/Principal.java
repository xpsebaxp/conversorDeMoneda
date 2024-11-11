import java.util.Scanner;


public class Principal {
    public static void main(String[] args) {

        String opcion = "";
        int bandera = 0;
        Scanner lectura = new Scanner(System.in);

        while (bandera == 0) {
            double valor = 0.0;
            String resultado = "";
            System.out.println("**************************************************\n"+
                    "\n"+
                    "1) Dólar =>> Peso argentino\n"+
                    "2) Peso argentino =>> Dólar\n"+
                    "3) Dólar =>> Real brasileño\n"+
                    "4) Real brasileño =>> Dólar\n"+
                    "5) Dólar =>> Peso colombiano\n"+
                    "6) Peso colombiano =>> Dólar\n"+
                    "7) Salir\n"+
                    "Elija una opción válida: "+
                    "\n"+
                    "\n**************************************************");
            ConsultaMoneda monedas = new ConsultaMoneda();

            opcion = String.valueOf((lectura.nextInt()));
            if (opcion.equals("1")) {
                System.out.println("ingrese el valor que desea convertir: ");
                valor = lectura.nextDouble();
                resultado = monedas.convertirMoneda(1, valor, "USD");
                System.out.println(resultado);
                bandera = 1;
            } else if (opcion.equals("2")) {
                System.out.println("ingrese el valor que desea convertir: ");
                valor = lectura.nextDouble();
                resultado = monedas.convertirMoneda(2, valor, "ARS");
                System.out.println(resultado);
                bandera = 1;
            } else if (opcion.equals("3")) {
                System.out.println("ingrese el valor que desea convertir: ");
                valor = lectura.nextDouble();
                resultado = monedas.convertirMoneda(3, valor, "USD");
                System.out.println(resultado);
                bandera = 1;
            } else if (opcion.equals("4")) {
                System.out.println("ingrese el valor que desea convertir: ");
                valor = lectura.nextDouble();
                resultado = monedas.convertirMoneda(4, valor, "BRL");
                System.out.println(resultado);
                bandera = 1;
            } else if (opcion.equals("5")) {
                System.out.println("ingrese el valor que desea convertir: ");
                valor = lectura.nextDouble();
                resultado = monedas.convertirMoneda(5, valor, "USD");
                System.out.println(resultado);
                bandera = 1;
            } else if (opcion.equals("6")) {
                System.out.println("ingrese el valor que desea convertir: ");
                valor = lectura.nextDouble();
                resultado = monedas.convertirMoneda(6, valor, "COP");
                System.out.println(resultado);
                bandera = 1;
            } else if (opcion.equals("7")) {
                System.out.println("Gracias por usar esta herramienta");
                System.exit(0);
            } else {
                System.out.println("No existe opción válida.");
                bandera = 0;
            }
        }
    }


}
