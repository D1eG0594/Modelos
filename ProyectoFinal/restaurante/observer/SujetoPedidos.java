package observer;

public interface SujetoPedidos {
    void agregarObservador(ObservadorPedido obs);
    void notificarNuevoPedido(pedido.Pedido pedido);
}
