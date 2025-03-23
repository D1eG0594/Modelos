public class Cuadrado extends Figura {
    private Operacion multiplicacion;

    public Cuadrado(Operacion multiplicacion) {
        this.multiplicacion = multiplicacion;
    }

    @Override
    public float area(float valor1, float valor2) {
        float[] valores = {valor1, valor2};
        return multiplicacion.operar(valores);
    }
}
