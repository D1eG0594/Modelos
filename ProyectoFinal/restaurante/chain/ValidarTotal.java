package chain;

import pedido.Pedido;
import salida.Salida;
import salida.SalidaConsola;

public class ValidarTotal extends ManejadorPedido {
    private Salida salida = new SalidaConsola();

    @Override
    protected boolean manejar(Pedido pedido) {
        if (pedido.calcularTotal() <= 0) {
            salida.enviar("El total debe ser mayor a $0.");
            return false;
        }
        return true;
    }
}
// Este manejador valida que el total del pedido sea mayor a 0.

