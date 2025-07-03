package memento;

import java.util.ArrayList;
import java.util.List;

public class HistorialPedidos {
    private static HistorialPedidos instancia;
    private final List<MementoPedido> historial = new ArrayList<>();

    private HistorialPedidos() {}

    public static HistorialPedidos getInstancia() {
        if (instancia == null) {
            instancia = new HistorialPedidos();
        }
        return instancia;
    }

    public void guardarMemento(MementoPedido memento) {
        historial.add(memento);
    }

    public List<MementoPedido> getHistorial() {
        return historial;
    }

    public void limpiarHistorial() {
        historial.clear();
    }

    public void actualizarEstado(MementoPedido nuevo) {
        for (int i = 0; i < historial.size(); i++) {
            MementoPedido existente = historial.get(i);

            // Comparación sencilla por lista de productos y total
            if (existente.getProductos().equals(nuevo.getProductos()) &&
                existente.getTotal() == nuevo.getTotal()) {
                
                // Reemplazar el memento existente por el actualizado
                historial.set(i, nuevo);
                return;
            }
        }

        // Si no lo encontró, lo agrega normalmente
        historial.add(nuevo);
    }
}

