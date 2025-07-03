package interfaz;

import observer.ObservadorPedido;
import pedido.Pedido;
import pedido.estado.Listo;
import salida.Salida;
import salida.SalidaConsola;
import command.Comando;
import command.MarcarListoCommand;
import mediador.Mediador;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VistaChef extends JPanel implements ObservadorPedido {
    private DefaultListModel<Pedido> modeloPedidos;
    private JList<Pedido> listaPedidos;
    private Salida salida = new SalidaConsola();
    private Mediador mediador;

    public VistaChef() {
        setLayout(new BorderLayout());
        modeloPedidos = new DefaultListModel<>();
        listaPedidos = new JList<>(modeloPedidos);
        listaPedidos.setCellRenderer(new PedidoRenderer());

        JScrollPane scroll = new JScrollPane(listaPedidos);
        add(scroll, BorderLayout.CENTER);

        JButton btnMarcarListo = new JButton("Marcar como Listo");
        btnMarcarListo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Pedido seleccionado = listaPedidos.getSelectedValue();
                if (seleccionado != null) {
                    Comando cmd = new MarcarListoCommand(seleccionado);
                    cmd.ejecutar();
                    salida.enviar("🍽️ Pedido marcado como LISTO.");
                    actualizarLista();
                }
            }
        });

        add(btnMarcarListo, BorderLayout.SOUTH);
    }

    @Override
    public void nuevoPedidoRecibido(Pedido pedido) {
        modeloPedidos.addElement(pedido);
    }

    // Método que elimina de la lista los pedidos que ya están listos
    private void actualizarLista() {
        DefaultListModel<Pedido> nuevaLista = new DefaultListModel<>();
        for (int i = 0; i < modeloPedidos.size(); i++) {
            Pedido p = modeloPedidos.get(i);
            if (!(p.getEstado() instanceof Listo)) {
                nuevaLista.addElement(p);
            }
        }
        modeloPedidos = nuevaLista;
        listaPedidos.setModel(modeloPedidos);
    }

    // Personalización visual de los pedidos en la lista
    private static class PedidoRenderer extends DefaultListCellRenderer {
        @Override
        public Component getListCellRendererComponent(
                JList<?> list, Object value, int index,
                boolean isSelected, boolean cellHasFocus) {

            Component c = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

            if (value instanceof Pedido) {
                Pedido p = (Pedido) value;
                setText(p.getDescripcion() + " | Estado: " + p.getEstadoNombre());
            }

            return c;
        }
    }

    public void setMediador(Mediador mediador) {
        this.mediador = mediador;
    }
}
