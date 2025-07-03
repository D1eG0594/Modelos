package bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import salida.*;

public class ConexionBD {
    private static final String URL = "jdbc:sqlite:datos/restaurante.db"; 
    static Salida salidaConsola = new SalidaConsola();
    public static Connection getConexion() {
        try {
            return DriverManager.getConnection(URL);
        } catch (SQLException e) {
            //Error al conectar con la base de datos.
            e.printStackTrace();
            return null;
        }
    }
}