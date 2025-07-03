package chain;

import pedido.Pedido;
import salida.*;


public class ValidarProductos extends ManejadorPedido {
    private Salida salidaConsola = new SalidaConsola();
    private SalidaGUI salidaGUI = new SalidaGUI();

    @Override
    protected boolean manejar(Pedido pedido) {
        if (pedido.getProductos().isEmpty()) {
            salidaConsola.enviar("No hay productos en el pedido.");
            salidaGUI.enviar("No hay productos en el pedido.");
            return false;
        }
        return true;
    }
}
// Este manejador valida que el pedido tenga al menos un producto.

