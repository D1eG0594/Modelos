package command;

import pedido.Pedido;
import pedido.estado.Listo;

public class MarcarListoCommand implements Comando {
    private Pedido pedido;

    public MarcarListoCommand(Pedido pedido) {
        this.pedido = pedido;
    }

    @Override
    public void ejecutar() {
        pedido.setEstado(new Listo());
    }
}
