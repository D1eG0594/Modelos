public class FabricaCuadrado extends FabricaFigura {
    private Operacion multiplicacion;

    public FabricaCuadrado(Operacion multiplicacion) {
        this.multiplicacion = multiplicacion;
    }

    @Override
    public Figura crearFigura() {
        return new Cuadrado(multiplicacion);
    }
}