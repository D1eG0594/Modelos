public class Main {
    public static void main(String[] args) {
        // Usamos la fábrica concreta para crear entrada y salida
        FabricaAbstracta fabricaConsola = new FabricaConsola();
        Suma suma = new Suma();
        
        // Crear entrada y salida concretas
        Entrada entrada = fabricaConsola.crearEntrada();
        Salida salida = fabricaConsola.crearSalida();
        
        int numeros[] = entrada.capturar();

        int resultado = suma.operar(numeros);

        String mensaje = resultado + "";
        
        // Mostrar el número capturado
        salida.enviar(mensaje);


    }
}

