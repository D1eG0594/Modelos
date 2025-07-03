package pedido;

import java.util.ArrayList;
import java.util.List;
import producto.Producto;
import salida.Salida;
import salida.SalidaConsola;
import pedido.estado.EstadoPedido;
import pedido.estado.Pendiente;
import memento.MementoPedido;

public class Pedido implements Cloneable {
    private List<Producto> productos = new ArrayList<>();
    private Salida salidaConsola = new SalidaConsola();
    private EstadoPedido estado;

    public Pedido() {
        this.estado = new Pendiente(); // estado inicial
    }

    public void agregarProducto(Producto p) {
        productos.add(p);
        salidaConsola.enviar("Producto agregado: " + p.getDescripcion());
    }

    public double calcularTotal() {
        double total = 0;
        for (Producto p : productos) {
            total += p.getPrecio();
        }
        return total;
    }

    public String getDescripcion() {
        StringBuilder sb = new StringBuilder();
        for (Producto p : productos) {
            sb.append(p.getDescripcion()).append(", ");
        }
        return sb.toString();
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public EstadoPedido getEstado() {
        return estado;
    }

    public void setEstado(EstadoPedido estado) {
        this.estado = estado;
    }

    public String getEstadoNombre() {
        return estado.getNombreEstado();
    }

    public MementoPedido crearMemento() {
        return new MementoPedido(new ArrayList<>(productos), getEstadoNombre(), calcularTotal());
    }

    @Override
    public Pedido clone() {
        Pedido clon = new Pedido();
        for (Producto p : this.productos) {
            clon.agregarProducto(p); // ya viene decorado, así que lo clona tal cual
        }
        clon.setEstado(this.estado);
        return clon;
    }
}