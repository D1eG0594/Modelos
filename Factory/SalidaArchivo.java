import java.io.FileWriter;
import java.io.IOException;

public class SalidaArchivo implements Salida {
    private String nombreArchivo = "operacion.txt";

    @Override
    public void enviar(String mensaje) {
        try (FileWriter escritor = new FileWriter(nombreArchivo, true)) { 
            escritor.write(mensaje + System.lineSeparator()); // Agrega una nueva línea
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo.");
        }
    }

    
    public void enviarFigura(String figura, float[] valores, float area) {
        try (FileWriter escritor = new FileWriter(nombreArchivo, true)) { 
            escritor.write("Figura: " + figura + System.lineSeparator());
            escritor.write("Dimensiones: ");
            for (float valor : valores) {
                escritor.write(valor + " ");
            }
            escritor.write(System.lineSeparator());
            escritor.write("Área: " + area + System.lineSeparator());
            escritor.write("-----------------------------" + System.lineSeparator()); // Separador
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo.");
        }
    }
}
