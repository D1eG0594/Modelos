public class PruebaBicicletaDecorator {
    public static void main(String[] args) {

        Bicicleta biciEconomica = new BicicletaBase();
        biciEconomica = new CascoDecorator(biciEconomica);

        System.out.println("Descripción: " + biciEconomica.getDescripcion());
        System.out.println("Costo total: $" + biciEconomica.getCosto());


        Bicicleta biciFull = new BicicletaBase();
        biciFull = new CascoDecorator(biciFull);
        biciFull = new GPSDecorator(biciFull);
        biciFull = new LucesDecorator(biciFull);

        System.out.println("Descripción: " + biciFull.getDescripcion());
        System.out.println("Costo total: $" + biciFull.getCosto());
    }
}