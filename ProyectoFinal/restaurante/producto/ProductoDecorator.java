package producto;

public abstract class ProductoDecorator implements Producto {
    protected Producto producto; // producto a decorar

    public ProductoDecorator(Producto producto) {
        this.producto = producto;
    }

    public String getDescripcion() {
        return producto.getDescripcion();
    }

    public double getPrecio() {
        return producto.getPrecio();
    }

    public Producto getProducto() {
        return producto;
    }
}