public class Bicicleta {
    private final String modelo;
    private final String tipo;
    private final String color;

    public Bicicleta(String modelo, String tipo, String color) {
        this.modelo = modelo;
        this.tipo = tipo;
        this.color = color;
    }

    public void mostrarInfo(String cliente, int horas) {
        System.out.println("Cliente: " + cliente +
            " | Modelo: " + modelo +
            ", Tipo: " + tipo +
            ", Color: " + color +
            ", Horas: " + horas);
    }
}