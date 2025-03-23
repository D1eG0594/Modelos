public class Triangulo extends Figura {
    private Operacion multiplicacion;

    public Triangulo(Operacion multiplicacion) {
        this.multiplicacion = multiplicacion;
    }

    @Override
    public float area(float base, float altura) {
        float[] valores = {base, altura};
        return multiplicacion.operar(valores) / 2;
    }
}