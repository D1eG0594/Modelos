package cocina;

import pedido.Pedido;
import salida.*;

public class Cocina {
    private Salida salidaConsola = new SalidaConsola();

    public void prepararPedido(Pedido pedido) {
        salidaConsola.enviar("Cocinando: " + pedido.getDescripcion());
        // Simular preparación...
    }
}
