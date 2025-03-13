package Suma;

public class Suma {
    public static void main(String[] args) {
        Entrada entrada = new Entrada();
        Salida salida = new Salida();
        SalidaArchivo salidaArchivo = new SalidaArchivo();
        EntradaArchivo entradaArchivo = new EntradaArchivo();

        // Pedir números
        salida.enviar("Ingrese el primer número:");
        int num1 = entrada.capturar();
        
        salida.enviar("Ingrese el segundo número:");
        int num2 = entrada.capturar();

        // Realizar la suma
        int resultado = num1 + num2;
        String mensaje = "La suma es: " + resultado;

        // Mostrar y guardar el resultado
        salida.enviar(mensaje);
        salidaArchivo.enviar(mensaje);

        // Leer desde el archivo y mostrar
        String resultadoArchivo = entradaArchivo.capturar();
        salida.enviar("Leído desde el archivo: " + resultadoArchivo);
    }
}