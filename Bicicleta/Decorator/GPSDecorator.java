public class GPSDecorator extends BicicletaDecorator {
    public GPSDecorator(Bicicleta bicicleta) {
        super(bicicleta);
    }

    @Override
    public String getDescripcion() {
        return bicicleta.getDescripcion() + " + GPS";
    }

    @Override
    public double getCosto() {
        return bicicleta.getCosto() + 15.0;
    }
}