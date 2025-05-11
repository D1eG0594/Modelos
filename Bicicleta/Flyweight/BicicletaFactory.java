import java.util.HashMap;
import java.util.Map;

public class BicicletaFactory {
    private static final Map<String, Bicicleta> bicicletas = new HashMap<>();

    public static Bicicleta obtenerBicicleta(String modelo, String tipo, String color) {
        String clave = modelo + "-" + tipo + "-" + color;

        if (!bicicletas.containsKey(clave)) {
            bicicletas.put(clave, new Bicicleta(modelo, tipo, color));
            System.out.println("Nueva bicicleta creada: " + clave);
        }

        return bicicletas.get(clave);
    }
}