package pedido.estado;

public class Preparando implements EstadoPedido {
    @Override
    public String getNombreEstado() {
        return "En preparación";
    }
}