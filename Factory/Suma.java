public class Suma implements Operacion {
    @Override
    public float operar(float[] numeros) {
        float resultado = 0;
        for (float num : numeros) {
            resultado += num; // Suma normal
        }
        return resultado;
    }
}
