package mediador;

import pedido.Pedido;

public interface Mediador {
    void notificar(Object remitente, String evento, Pedido pedido);
}

