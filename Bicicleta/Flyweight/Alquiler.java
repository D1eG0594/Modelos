public class Alquiler {
    private final String cliente;
    private final int horas;
    private final Bicicleta bicicleta;

    public Alquiler(String cliente, int horas, Bicicleta bicicleta) {
        this.cliente = cliente;
        this.horas = horas;
        this.bicicleta = bicicleta;
    }

    public void mostrarDetalle() {
        bicicleta.mostrarInfo(cliente, horas);
    }
}




