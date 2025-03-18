import java.util.Scanner;

public class EntradaConsola implements Entrada {

    @Override
    public int[] capturar() {
        Scanner scanner = new Scanner(System.in);
        int[] numeros = new int[2];

        try {
            System.out.print("Ingresa el primer número: ");
            numeros[0] = Integer.parseInt(scanner.nextLine());

            System.out.print("Ingresa el segundo número: ");
            numeros[1] = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Error: Entrada no válida como número.");
            return null;
        }

        return numeros;
    }
}
