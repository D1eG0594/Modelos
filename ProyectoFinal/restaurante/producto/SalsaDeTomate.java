package producto;

public class SalsaDeTomate extends ProductoDecorator {
    public SalsaDeTomate(Producto producto) {
        super(producto);
    }

    @Override
    public String getDescripcion() {
        return producto.getDescripcion() + " + Salsa de Tomate";
    }

    @Override
    public double getPrecio() {
        return producto.getPrecio() + 0.50;
    }
}