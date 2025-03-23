public class Main {
    public static void main(String[] args) {
        // Crear fábricas para entrada y salida
        FabricaAbstracta fabricaConsola = new FabricaConsola();

        // Crear fábricas de operaciones
        FabricaOperaciones fabricaMultiplicacion = new FabricaMultiplicacion();

        // Crear las operaciones
        Operacion multiplicacion = fabricaMultiplicacion.crearOperacion();

        // Crear entrada y salida concretas
        Entrada entradaConsola = fabricaConsola.crearEntrada();
        Salida salidaConsola = fabricaConsola.crearSalida();
        SalidaArchivo salidaArchivo = new SalidaArchivo(); // Para guardar en archivo

        Figura figura = null;
        float[] valores = null;
        String nombreFigura = "";

        // Pedir al usuario la figura
        salidaConsola.enviar("Seleccione la figura para calcular el área:");
        salidaConsola.enviar("1. Cuadrado");
        salidaConsola.enviar("2. Rectángulo");
        salidaConsola.enviar("3. Triángulo");
        salidaConsola.enviar("4. Círculo");
        salidaConsola.enviar("Ingrese el número de la opción:");

        int figuraSeleccionada = (int) entradaConsola.capturar(); // Conversión explícita de float a int

        // Seleccionar la fábrica de la figura
        switch (figuraSeleccionada) {
            case 1: // Cuadrado (solo necesita un número)
                salidaConsola.enviar("Ingrese el lado del cuadrado:");
                float lado = capturarNumeroValido(entradaConsola, salidaConsola);
                valores = new float[]{lado}; // Lo almacena en un array
                FabricaFigura fabricaCuadrado = new FabricaCuadrado(multiplicacion);
                figura = fabricaCuadrado.crearFigura();
                nombreFigura = "Cuadrado";
                break;

            case 2: // Rectángulo (necesita base y altura)
                salidaConsola.enviar("Ingrese la base del rectángulo:");
                float baseRect = capturarNumeroValido(entradaConsola, salidaConsola);
                salidaConsola.enviar("Ingrese la altura del rectángulo:");
                float alturaRect = capturarNumeroValido(entradaConsola, salidaConsola);
                valores = new float[]{baseRect, alturaRect}; // Guarda ambos valores
                FabricaFigura fabricaRectangulo = new FabricaRectangulo(multiplicacion);
                figura = fabricaRectangulo.crearFigura();
                nombreFigura = "Rectángulo";
                break;

            case 3: // Triángulo (necesita base y altura)
                salidaConsola.enviar("Ingrese la base del triángulo:");
                float baseTri = capturarNumeroValido(entradaConsola, salidaConsola);
                salidaConsola.enviar("Ingrese la altura del triángulo:");
                float alturaTri = capturarNumeroValido(entradaConsola, salidaConsola);
                valores = new float[]{baseTri, alturaTri};
                FabricaFigura fabricaTriangulo = new FabricaTriangulo(multiplicacion);
                figura = fabricaTriangulo.crearFigura();
                nombreFigura = "Triángulo";
                break;

            case 4: // Círculo (solo necesita un número)
                salidaConsola.enviar("Ingrese el radio del círculo:");
                float radio = capturarNumeroValido(entradaConsola, salidaConsola);
                valores = new float[]{radio};
                FabricaFigura fabricaCirculo = new FabricaCirculo(multiplicacion);
                figura = fabricaCirculo.crearFigura();
                nombreFigura = "Círculo";
                break;

            default:
                salidaConsola.enviar("Opción inválida.");
                return;
        }

        // Calcular el área
        float area = figura.area(valores[0], (valores.length > 1 ? valores[1] : valores[0]));

        // Mostrar el resultado en consola
        salidaConsola.enviar("El área de la figura es: " + area);

        // Guardar en archivo
        salidaArchivo.enviarFigura(nombreFigura, valores, area);
    }

    // Método para capturar un número válido
    private static float capturarNumeroValido(Entrada entrada, Salida salida) {
        while (true) {
            try {
                float numero = entrada.capturar();
                return numero; // Si es válido, lo devuelve
            } catch (NumberFormatException e) {
                salida.enviar("Entrada no válida. Por favor, ingrese un número.");
            }
        }
    }
}
