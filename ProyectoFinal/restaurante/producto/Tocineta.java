package producto;

public class Tocineta extends ProductoDecorator {
    public Tocineta(Producto producto) {
        super(producto);
    }

    @Override
    public String getDescripcion() {
        return producto.getDescripcion() + " + Tocineta";
    }

    @Override
    public double getPrecio() {
        return producto.getPrecio() + 3.0;
    }
}