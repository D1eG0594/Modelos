public class FabricaCirculo extends FabricaFigura {
    private Operacion multiplicacion;

    public FabricaCirculo(Operacion multiplicacion) {
        this.multiplicacion = multiplicacion;
        
    }

    @Override
    public Figura crearFigura() {
        return new Circulo(multiplicacion);
    }
}