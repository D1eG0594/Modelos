public class Suma {
    public static void main(String[] args) {
        Entrada entrada = new Entrada();
        Salida salida = new Salida();

        // Pedir números
        salida.enviar("Ingrese el primer número:");
        int num1 = AdaptadorSuma.convertirAEntero(entrada.capturar());

        salida.enviar("Ingrese el segundo número:");
        int num2 = AdaptadorSuma.convertirAEntero(entrada.capturar());

        // Realizar la suma
        int resultado = num1 + num2;
        String mensaje = "La suma es: " + AdaptadorSuma.convertirACadena(resultado);

        // Mostrar el resultado
        salida.enviar(mensaje);
    }
}
