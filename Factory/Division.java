public class Division implements Operacion {
    @Override
    public float operar(float[] numeros) {
        if (numeros.length == 0) return 1;
        float resultado = numeros[0];
        for (int i = 1; i < numeros.length; i++) {
            if (numeros[i] == 0) throw new ArithmeticException("No se puede dividir por cero");
            int contador = 0;
            float divisor = Math.abs(numeros[i]);
            float dividendo = Math.abs(resultado);
            boolean negativo = (resultado < 0) ^ (numeros[i] < 0);

            while (dividendo >= divisor) {
                dividendo += -divisor; // Resta usando suma del negativo
                contador++;
            }
            resultado = negativo ? -contador : contador;
        }
        return resultado;
    }
}
