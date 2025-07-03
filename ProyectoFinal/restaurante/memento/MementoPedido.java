package memento;

import producto.Producto;
import java.util.List;

public class MementoPedido {
    private final List<Producto> productos;
    private final String estado;
    private final double total;

    public MementoPedido(List<Producto> productos, String estado, double total) {
        this.productos = productos;
        this.estado = estado;
        this.total = total;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public String getEstado() {
        return estado;
    }

    public double getTotal() {
        return total;
    }
}

