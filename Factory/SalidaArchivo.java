import java.io.FileWriter;
import java.io.IOException;

public class SalidaArchivo implements Salida {
    private String nombreArchivo = "operacion.txt";

    @Override
    public void enviar(String mensaje) {
        try (FileWriter escritor = new FileWriter(nombreArchivo, true)) { // Modo append activado
            escritor.write(mensaje + System.lineSeparator()); // Agrega una nueva línea
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo.");
        }
    }
}
