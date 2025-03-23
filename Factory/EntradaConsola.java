import java.util.Scanner;

public class EntradaConsola implements Entrada {

    @Override
    public float capturar() {
        Scanner scanner = new Scanner(System.in);
        float numero;

        try {
            numero = Float.parseFloat(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Error: Entrada no válida como número.");
            scanner.close();
            return 0; // Devuelve 0 si hay un error
        }

        scanner.close();

        return numero;
    }
}
