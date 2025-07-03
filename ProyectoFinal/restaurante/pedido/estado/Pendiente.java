package pedido.estado;

public class Pendiente implements EstadoPedido {
    @Override
    public String getNombreEstado() {
        return "Pendiente";
    }
}