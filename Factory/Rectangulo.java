public class Rectangulo extends Figura {
    private Operacion multiplicacion;

    public Rectangulo(Operacion multiplicacion) {
        this.multiplicacion = multiplicacion;
    }

    @Override
    public float area(float base, float altura) {
        float[] valores = {base, altura};
        return multiplicacion.operar(valores);
    }
}
