package mediador;

import interfaz.VistaChef;
import interfaz.VistaMesero;
import interfaz.VistaPago;
import interfaz.VistaHistorial;
import memento.HistorialPedidos;
import pedido.Pedido;


public class MediadorRestaurante implements Mediador {
    private VistaChef chef;
    private VistaMesero mesero;
    private VistaPago pago;
    private VistaHistorial historial;

    public void setChef(VistaChef chef) {
        this.chef = chef;
    }

    public void setMesero(VistaMesero mesero) {
        this.mesero = mesero;
    }

    public void setPago(VistaPago pago) {
        this.pago = pago;
    }

    public void setHistorial(VistaHistorial historial) {
        this.historial = historial;
    }

    @Override
    public void notificar(Object remitente, String evento, Pedido pedido) {
        switch (evento) {
            case "pedidoListo":
                if (mesero != null) mesero.nuevoPedidoRecibido(pedido);
                break;

            case "pedidoEntregado":
                if (pago != null) pago.nuevoPedidoRecibido(pedido);
                break;

            case "pedidoPagado":
                HistorialPedidos.getInstancia().guardarMemento(pedido.crearMemento());
                if (historial != null) historial.mostrarHistorial(); 
                break;
        }
    }
}

