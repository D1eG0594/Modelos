public class FabricaRectangulo extends FabricaFigura {
    private Operacion multiplicacion;

    public FabricaRectangulo(Operacion multiplicacion) {
        this.multiplicacion = multiplicacion;
    }

    @Override
    public Figura crearFigura() {
        return new Rectangulo(multiplicacion);
    }
}