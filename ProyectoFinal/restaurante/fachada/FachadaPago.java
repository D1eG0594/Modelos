package fachada;

import memento.HistorialPedidos;
import pago.FormaPago;
import pedido.Pedido;
import pedido.estado.Pagado;

public class FachadaPago {
    public void procesarPago(Pedido pedido, FormaPago metodoPago) {
        if (pedido == null || metodoPago == null) return;

        metodoPago.pagar(pedido.calcularTotal());
        pedido.setEstado(new Pagado());
        HistorialPedidos.getInstancia().actualizarEstado(pedido.crearMemento());
    }
}
