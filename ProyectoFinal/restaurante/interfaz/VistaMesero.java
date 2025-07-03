package interfaz;

import memento.HistorialPedidos;
import memento.MementoPedido;
import observer.ObservadorPedido;
import pedido.Pedido;
import pedido.estado.Entregado;
import pedido.estado.Listo;
import salida.Salida;
import salida.SalidaConsola;

import javax.swing.*;

import mediador.Mediador;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class VistaMesero extends JPanel implements ObservadorPedido {
    private DefaultListModel<Pedido> modeloPendientes = new DefaultListModel<>();
    private DefaultListModel<Pedido> modeloListos = new DefaultListModel<>();

    private JList<Pedido> listaPendientes = new JList<>(modeloPendientes);
    private JList<Pedido> listaListos = new JList<>(modeloListos);

    private Salida salida = new SalidaConsola();
    private List<Pedido> pedidos = new ArrayList<>();

    private Mediador mediador; 

    public VistaMesero() {
        setLayout(new GridLayout(1, 2));

        // Renderer para mostrar estado
        listaPendientes.setCellRenderer(new PedidoRenderer());
        listaListos.setCellRenderer(new PedidoRenderer());

        // --- Panel Pendientes ---
        JPanel panelPendientes = new JPanel(new BorderLayout());
        panelPendientes.setBorder(BorderFactory.createTitledBorder("🕓 Pendientes"));
        panelPendientes.add(new JScrollPane(listaPendientes), BorderLayout.CENTER);

        // --- Panel Listos ---
        JPanel panelListos = new JPanel(new BorderLayout());
        panelListos.setBorder(BorderFactory.createTitledBorder("✅ Listos para entregar"));
        panelListos.add(new JScrollPane(listaListos), BorderLayout.CENTER);

        // Botón "Entregado"
        JButton btnEntregar = new JButton("Marcar como Entregado");
        btnEntregar.addActionListener(e -> {
            Pedido seleccionado = listaListos.getSelectedValue();
            if (seleccionado != null) {
                seleccionado.setEstado(new Entregado()); // Cambiar estado
                HistorialPedidos.getInstancia().guardarMemento(seleccionado.crearMemento()); // Guardar en historial
                pedidos.remove(seleccionado); // Quitar de la vista
                actualizarListas();
                salida.enviar("✅ Pedido entregado y enviado al historial.");
            }
        });
        panelListos.add(btnEntregar, BorderLayout.SOUTH);

        add(panelPendientes);
        add(panelListos);

        // Timer para actualizar separación entre pendientes y listos
        Timer timer = new Timer(1000, e -> actualizarListas());
        timer.start();
    }

    @Override
    public void nuevoPedidoRecibido(Pedido pedido) {
        pedidos.add(pedido);
        actualizarListas();
    }

    private void actualizarListas() {
        Pedido seleccionadoPendiente = listaPendientes.getSelectedValue();
        Pedido seleccionadoListo = listaListos.getSelectedValue();

        modeloPendientes.clear();
        modeloListos.clear();

        for (Pedido p : pedidos) {
            if (p.getEstado() instanceof Listo) {
                modeloListos.addElement(p);
            } else {
                modeloPendientes.addElement(p);
            }
        }

        if (seleccionadoPendiente != null) {
            listaPendientes.setSelectedValue(seleccionadoPendiente, true);
        }
        if (seleccionadoListo != null) {
            listaListos.setSelectedValue(seleccionadoListo, true);
        }
    }

    // Renderer personalizado
    private static class PedidoRenderer extends DefaultListCellRenderer {
        @Override
        public Component getListCellRendererComponent(
                JList<?> list, Object value, int index,
                boolean isSelected, boolean cellHasFocus) {

            Component c = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
            if (value instanceof Pedido) {
                Pedido p = (Pedido) value;
                setText(p.getDescripcion() + " | Estado: " + p.getEstadoNombre()); // <<<<< AQUÍ se usa getEstadoNombre()
            }
            return c;
        }
    }

    public void setMediador(Mediador mediador) {
        this.mediador = mediador;
    }
}