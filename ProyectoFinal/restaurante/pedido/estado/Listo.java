package pedido.estado;

public class Listo implements EstadoPedido {
    @Override
    public String getNombreEstado() {
        return "Listo para entregar";
    }
}