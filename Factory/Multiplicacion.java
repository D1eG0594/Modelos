public class Multiplicacion implements Operacion {
    @Override
    public float operar(float[] numeros) {
        if (numeros == null || numeros.length == 0) {
            throw new IllegalArgumentException("El arreglo de números no puede estar vacío.");
        }

        float resultado = 1;

        for (float num : numeros) {
            boolean negativo = (num < 0) ^ (resultado < 0); // Determinar si el resultado será negativo
            float absNum = Math.abs(num);
            float absResultado = Math.abs(resultado);

            float temp = 0;
            for (int i = 0; i < (int) absNum; i++) {
                temp += absResultado; // Suma repetida para la parte entera
            }

            // Manejo de la parte decimal (si existe)
            float parteDecimal = absNum - (int) absNum;
            temp += absResultado * parteDecimal;

            resultado = negativo ? -temp : temp;
        }

        return resultado;
    }
}