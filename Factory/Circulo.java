public class Circulo extends Figura {
    private Operacion multiplicacion;

    public Circulo(Operacion multiplicacion) {
        this.multiplicacion = multiplicacion;
    }

    @Override
    public float area(float radio, float ignorado) {
        float[] valores = {radio, radio, (float) Math.PI};
        return multiplicacion.operar(valores);
    }
}
