public class Resta implements Operacion {
    @Override
    public float operar(float[] numeros) {
        if (numeros.length == 0) return 0;
        float resultado = numeros[0];
        for (int i = 1; i < numeros.length; i++) {
            resultado += (-numeros[i]); // Resta como suma del opuesto
        }
        return resultado;
    }
}