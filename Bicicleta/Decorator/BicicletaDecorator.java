public abstract class BicicletaDecorator implements Bicicleta {
    protected Bicicleta bicicleta;

    public BicicletaDecorator(Bicicleta bicicleta) {
        this.bicicleta = bicicleta;
    }

    @Override
    public String getDescripcion() {
        return bicicleta.getDescripcion();
    }

    @Override
    public double getCosto() {
        return bicicleta.getCosto();
    }
}



