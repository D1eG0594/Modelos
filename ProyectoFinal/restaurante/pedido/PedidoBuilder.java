package pedido;

import producto.Producto;
import java.util.ArrayList;
import java.util.List;
import cliente.Cliente;

public class PedidoBuilder {
    private List<Producto> productos = new ArrayList<>();
    private Cliente cliente;

    public PedidoBuilder agregarProducto(Producto producto) {
        productos.add(producto);
        return this;
    }

    public PedidoBuilder conCliente(Cliente cliente) {
        this.cliente = cliente;
        return this;
    }

    public Pedido build() {
        Pedido pedido = new Pedido();
        for (Producto p : productos) {
            pedido.agregarProducto(p);
        }
        if (cliente != null) {
            cliente.agregarPedido(pedido);
        }
        return pedido;
    }

    public double calcularTotal() {
        double total = 0;
        for (Producto p : productos) {
            total += p.getPrecio();
        }
        return total;
    }

    public void eliminarProducto(int index) {
        if (index >= 0 && index < productos.size()) {
            productos.remove(index);
        }
    }

}