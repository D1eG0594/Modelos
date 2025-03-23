public class FabricaTriangulo extends FabricaFigura {
    private Operacion multiplicacion;

    public FabricaTriangulo(Operacion multiplicacion) {
        this.multiplicacion = multiplicacion;
    }

    @Override
    public Figura crearFigura() {
        return new Triangulo(multiplicacion);
    }
}