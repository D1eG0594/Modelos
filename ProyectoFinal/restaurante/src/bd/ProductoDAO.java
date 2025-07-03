package bd;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import producto.ProductoBase;
import salida.*;

public class ProductoDAO {

    

    public static List<ProductoBase> obtenerTodos() {
        final Salida salidaConsola = new SalidaConsola();
        List<ProductoBase> productos = new ArrayList<>();
        String sql = "SELECT nombre, precio FROM productos";

        try (Connection conn = ConexionBD.getConexion();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                String nombre = rs.getString("nombre");
                double precio = rs.getDouble("precio");
                productos.add(new ProductoBase(nombre, precio));
            }

        } catch (SQLException e) {
            salidaConsola.enviar("❌ Error al obtener productos:");
            e.printStackTrace();
        }

        return productos;
    }

    public static boolean insertarProducto(String nombre, double precio) {
        final Salida salidaConsola = new SalidaConsola();
        String sql = "INSERT INTO productos(nombre, precio) VALUES(?, ?)";

        try (Connection conn = ConexionBD.getConexion();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, nombre);
            pstmt.setDouble(2, precio);
            pstmt.executeUpdate();
            return true;

        } catch (SQLException e) {
            salidaConsola.enviar("❌ Error al insertar producto:");
            e.printStackTrace();
            return false;
        }
    }
}