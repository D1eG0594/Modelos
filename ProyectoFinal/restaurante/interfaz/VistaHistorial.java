package interfaz;

import memento.HistorialPedidos;
import memento.MementoPedido;

import javax.swing.*;
import java.awt.*;

public class VistaHistorial extends JPanel {
    private JTextArea area;

    public VistaHistorial() {
        setLayout(new BorderLayout());
        area = new JTextArea();
        area.setEditable(false);

        add(new JScrollPane(area), BorderLayout.CENTER);
    }

    public void mostrarHistorial() {
        area.setText("");
        for (MementoPedido m : HistorialPedidos.getInstancia().getHistorial()) {
            area.append("Pedido: \n");
            for (var prod : m.getProductos()) {
                area.append("- " + prod.getDescripcion() + " ($" + prod.getPrecio() + ")\n");
            }
            area.append("Estado: " + m.getEstado() + "\n");
            area.append("Total: $" + m.getTotal() + "\n");
            area.append("--------------------------\n");
        }
    }
}