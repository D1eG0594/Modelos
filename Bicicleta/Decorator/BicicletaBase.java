public class BicicletaBase implements Bicicleta {
    @Override
    public String getDescripcion() {
        return "Bicicleta estándar";
    }

    @Override
    public double getCosto() {
        return 100.0;
    }
}