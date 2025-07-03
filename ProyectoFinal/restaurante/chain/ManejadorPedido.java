package chain;

import pedido.Pedido;

public abstract class ManejadorPedido {
    protected ManejadorPedido siguiente;

    public ManejadorPedido enlazarSiguiente(ManejadorPedido siguiente) {
        this.siguiente = siguiente;
        return siguiente;
    }

    public boolean procesar(Pedido pedido) {
        if (manejar(pedido)) {
            if (siguiente != null) {
                return siguiente.procesar(pedido);
            }
            return true;
        }
        return false;
    }

    protected abstract boolean manejar(Pedido pedido);
}
