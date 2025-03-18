import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class EntradaArchivo implements Entrada {
    private String nombreArchivo = "operacion.txt";

    @Override
    public int[] capturar() {
        int[] numeros = new int[2];  // Podemos ajustar el tamaño según lo necesario
        int contador = 0;

        try (BufferedReader lector = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            while ((linea = lector.readLine()) != null && contador < 2) {
                try {
                    numeros[contador] = Integer.parseInt(linea.trim());
                    contador++;
                } catch (NumberFormatException e) {
                    System.out.println("Línea no válida como número: " + linea);
                    return null;
                }
            }

            if (contador < 2) {
                System.out.println("El archivo no contiene dos números válidos.");
                return null;
            }

        } catch (IOException e) {
            System.out.println("Error al leer el archivo.");
            return null;
        }

        return numeros;
    }
}