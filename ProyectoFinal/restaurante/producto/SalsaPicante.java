package producto;

public class SalsaPicante extends ProductoDecorator {
    public SalsaPicante(Producto producto) {
        super(producto);
    }

    @Override
    public String getDescripcion() {
        return producto.getDescripcion() + " + Salsa Picante";
    }

    @Override
    public double getPrecio() {
        return producto.getPrecio() + 1.0;
    }
}