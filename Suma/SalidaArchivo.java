package Suma;

import java.io.FileWriter;
import java.io.IOException;

public class SalidaArchivo {
    private String nombreArchivo = "resultado.txt";

    public void enviar(String mensaje) {
        try (FileWriter escritor = new FileWriter(nombreArchivo)) {
            escritor.write(mensaje);
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo.");
        }
    }
}
