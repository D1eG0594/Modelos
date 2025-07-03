package sistema;

import java.util.ArrayList;
import java.util.List;
import observer.ObservadorPedido;
import observer.SujetoPedidos;
import pedido.Pedido;

public class Restaurante implements SujetoPedidos {
    private static Restaurante instancia;
    private List<Pedido> pedidos = new ArrayList<>();
    private List<ObservadorPedido> observadores = new ArrayList<>();


    public static Restaurante getInstance() {
        if (instancia == null) {
            instancia = new Restaurante();
        }
        return instancia;
    }

    public void recibirPedido(Pedido p) {
        pedidos.add(p);
        notificarNuevoPedido(p);
    }

    @Override
    public void agregarObservador(ObservadorPedido obs) {
        observadores.add(obs);
    }

    @Override
    public void notificarNuevoPedido(Pedido pedido) {
        for (ObservadorPedido obs : observadores) {
            obs.nuevoPedidoRecibido(pedido);
        }
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }
}




