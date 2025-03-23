import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class EntradaArchivo implements Entrada {
    private String nombreArchivo = "operacion.txt";

    @Override
    public float capturar() {
        try (BufferedReader lector = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            while ((linea = lector.readLine()) != null) {
                try {
                    return Float.parseFloat(linea.trim()); // Devuelve el primer número válido
                } catch (NumberFormatException e) {
                    System.out.println("Línea no válida como número: " + linea);
                }
            }
            System.out.println("El archivo no contiene números válidos.");
        } catch (IOException e) {
            System.out.println("Error al leer el archivo.");
        }

        return 0; // Devuelve 0 si no se encuentra ningún número válido
    }

}