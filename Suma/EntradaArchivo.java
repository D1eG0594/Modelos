package Suma;

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class EntradaArchivo {
    private String nombreArchivo = "resultado.txt";

    public String capturar() {
        StringBuilder contenido = new StringBuilder();
        try (BufferedReader lector = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            while ((linea = lector.readLine()) != null) {
                contenido.append(linea);
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo.");
        }
        return contenido.toString();
    }
}
