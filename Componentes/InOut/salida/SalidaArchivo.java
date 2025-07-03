package salida;

import java.io.FileWriter;
import java.io.IOException;

public class SalidaArchivo implements Salida {
    private String ruta;

    public SalidaArchivo(String ruta) {
        this.ruta = ruta;
    }

    @Override
    public void enviar(String mensaje) {
        try (FileWriter fw = new FileWriter(ruta, true)) {
            fw.write(mensaje + "\n");
        } catch (IOException e) {
            System.out.println("Error escribiendo en archivo: " + e.getMessage());
        }
    }
}
