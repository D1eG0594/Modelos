package producto;

import salida.Salida;

public class FabricaProductoProxy {

    private Salida salida;

    public FabricaProductoProxy(Salida salida) {
        this.salida = salida;
    }

    public boolean registrarProducto(String nombre, double precio) {
        // Validaciones
        if (nombre == null || nombre.trim().isEmpty()) {
            salida.enviar(" Nombre no válido.");
            return false;
        }

        if (precio <= 0) {
            salida.enviar(" El precio debe ser mayor que 0.");
            return false;
        }

        // Validar existencia
        Producto existente = FabricaProducto.crearProductoPorNombre(nombre);
        if (existente != null) {
            salida.enviar(" Ya existe un producto con ese nombre.");
            return false;
        }

        // Insertar usando la fábrica real
        boolean exito = FabricaProducto.registrarProducto(nombre, precio);
        if (exito) {
            salida.enviar(" Producto agregado con éxito.");
        } else {
            salida.enviar(" Error al agregar el producto.");
        }

        return exito;
    }
}

