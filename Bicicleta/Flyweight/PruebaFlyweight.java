public class PruebaFlyweight {
    public static void main(String[] args) {
        Bicicleta bici1 = BicicletaFactory.obtenerBicicleta("Montañera", "Todoterreno", "Roja");
        Bicicleta bici2 = BicicletaFactory.obtenerBicicleta("Montañera", "Todoterreno", "Roja");
        Bicicleta bici3 = BicicletaFactory.obtenerBicicleta("Urbana", "Ciudad", "Azul");

        Alquiler a1 = new Alquiler("Carlos", 3, bici1);
        Alquiler a2 = new Alquiler("Ana", 2, bici2);
        Alquiler a3 = new Alquiler("Luis", 1, bici3);
        Alquiler a4 = new Alquiler("Pedro", 4, bici1);
        Alquiler a5 = new Alquiler("María", 5, bici3);

        a1.mostrarDetalle();
        a2.mostrarDetalle();
        a3.mostrarDetalle();
        a4.mostrarDetalle();
        a5.mostrarDetalle();
    }
}




