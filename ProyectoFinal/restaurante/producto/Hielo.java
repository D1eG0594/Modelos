package producto;

public class Hielo extends ProductoDecorator {
    public Hielo(Producto producto) {
        super(producto);
    }

    @Override
    public String getDescripcion() {
        return producto.getDescripcion() + " + Hielo";
    }

    @Override
    public double getPrecio() {
        return producto.getPrecio() + 0.5;
    }
}