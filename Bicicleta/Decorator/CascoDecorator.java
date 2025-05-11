public class CascoDecorator extends BicicletaDecorator {
    public CascoDecorator(Bicicleta bicicleta) {
        super(bicicleta);
    }

    @Override
    public String getDescripcion() {
        return bicicleta.getDescripcion() + " + Casco";
    }

    @Override
    public double getCosto() {
        return bicicleta.getCosto() + 10.0;
    }
}