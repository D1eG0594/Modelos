package producto;

public class ExtraQueso extends ProductoDecorator {
    public ExtraQueso(Producto producto) {
        super(producto);
    }

    @Override
    public String getDescripcion() {
        return producto.getDescripcion() + " + Queso Extra";
    }

    @Override
    public double getPrecio() {
        return producto.getPrecio() + 2.0;
    }
}