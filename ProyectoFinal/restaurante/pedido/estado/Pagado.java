package pedido.estado;

public class Pagado implements EstadoPedido {
    @Override
    public String getNombreEstado() {
        return "Pagado";
    }
}