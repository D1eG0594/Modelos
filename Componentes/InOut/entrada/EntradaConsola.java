package entrada;

import java.util.Scanner;

public class EntradaConsola implements Entrada {
    private static final Scanner scanner = new Scanner(System.in);

    @Override
    public String recibir(String mensaje) {
        System.out.print(mensaje + ": ");
        return scanner.nextLine();
    }
}
