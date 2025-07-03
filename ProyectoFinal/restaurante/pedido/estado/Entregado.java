package pedido.estado;

public class Entregado implements EstadoPedido {
    @Override
    public String getNombreEstado() {
        return "Entregado";
    }
}