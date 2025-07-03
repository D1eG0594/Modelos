package producto;

import bd.ProductoDAO;
import java.util.*;

public class FabricaProducto {
    private static Map<String, ProductoBase> cacheProductos = new HashMap<>();

    public static Producto crearProductoPorNombre(String nombreBuscado) {
        // Si está en cache, lo reutiliza (Flyweight)
        if (cacheProductos.containsKey(nombreBuscado.toLowerCase())) {
            return cacheProductos.get(nombreBuscado.toLowerCase());
        }

        // Si no, lo busca en BD y lo guarda en cache
        List<ProductoBase> lista = ProductoDAO.obtenerTodos();
        for (ProductoBase p : lista) {
            String nombre = p.getDescripcion().toLowerCase();
            cacheProductos.putIfAbsent(nombre, new ProductoBase(p.getDescripcion(), p.getPrecio()));
        }

        return cacheProductos.get(nombreBuscado.toLowerCase()); // puede ser null si no existe
    }

    public static List<ProductoBase> obtenerTodos() {
        if (cacheProductos.isEmpty()) {
            List<ProductoBase> productosBD = ProductoDAO.obtenerTodos();
            for (ProductoBase p : productosBD) {
                String nombre = p.getDescripcion().toLowerCase();
                cacheProductos.putIfAbsent(nombre, new ProductoBase(p.getDescripcion(), p.getPrecio()));
            }
        }
        return new ArrayList<>(cacheProductos.values());
    }

    public static boolean registrarProducto(String nombre, double precio) {
        boolean exito = ProductoDAO.insertarProducto(nombre, precio);
        if (exito) {
            cacheProductos.put(nombre.toLowerCase(), new ProductoBase(nombre, precio));
        }
        return exito;
    }
}


