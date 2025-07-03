package entrada;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class EntradaArchivo implements Entrada {
    private String rutaArchivo;

    public EntradaArchivo(String ruta) {
        this.rutaArchivo = ruta;
    }

    @Override
    public String recibir(String mensaje) {
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            return br.readLine(); // leer primera línea
        } catch (IOException e) {
            return "Error leyendo archivo: " + e.getMessage();
        }
    }
}
