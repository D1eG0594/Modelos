package command;

import pedido.Pedido;
import sistema.Restaurante;

public class ConfirmarPedidoCommand implements Comando {
    private Pedido pedido;

    public ConfirmarPedidoCommand(Pedido pedido) {
        this.pedido = pedido;
    }

    @Override
    public void ejecutar() {
        Restaurante.getInstance().recibirPedido(pedido);
    }
}

