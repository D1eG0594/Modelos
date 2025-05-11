public class LucesDecorator extends BicicletaDecorator {
    public LucesDecorator(Bicicleta bicicleta) {
        super(bicicleta);
    }

    @Override
    public String getDescripcion() {
        return bicicleta.getDescripcion() + " + Luces";
    }

    @Override
    public double getCosto() {
        return bicicleta.getCosto() + 5.0;
    }
}