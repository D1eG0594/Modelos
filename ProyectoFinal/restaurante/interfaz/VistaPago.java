package interfaz;

import memento.HistorialPedidos;
import memento.MementoPedido;
import observer.ObservadorPedido;
import pago.*;
import pedido.Pedido;
import pedido.estado.Entregado;
import pedido.estado.Pagado;
import fachada.FachadaPago;
import mediador.Mediador;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class VistaPago extends JPanel implements ObservadorPedido {
    private DefaultListModel<Pedido> modeloEntregados = new DefaultListModel<>();
    private JList<Pedido> listaPedidos;
    private JComboBox<FormaPago> comboPago;
    private JButton btnPagar;

    private List<Pedido> pedidos = new ArrayList<>();

    Mediador mediador;

    public VistaPago() {
        setLayout(new BorderLayout());

        listaPedidos = new JList<>(modeloEntregados);
        listaPedidos.setCellRenderer(new PedidoRenderer());
        

        // Panel inferior - selección de método de pago y botón
        JPanel panelInferior = new JPanel();
        comboPago = new JComboBox<>();
        comboPago.addItem(new PagoEfectivo());
        comboPago.addItem(new PagoTarjeta());
        comboPago.addItem(new PagoNequi());

        btnPagar = new JButton("Pagar Pedido");
        btnPagar.addActionListener(e -> pagarPedido());

        panelInferior.add(new JLabel("Método de pago:"));
        panelInferior.add(comboPago);
        panelInferior.add(btnPagar);

        add(new JScrollPane(listaPedidos), BorderLayout.CENTER);
        add(panelInferior, BorderLayout.SOUTH);

        // Timer para actualizar la lista de entregados
        Timer timer = new Timer(1000, e -> actualizarLista());
        timer.start();
    }

    @Override
    public void nuevoPedidoRecibido(Pedido pedido) {
        pedidos.add(pedido);
    }

    private void actualizarLista() {
        Pedido seleccionado = listaPedidos.getSelectedValue(); // Guardar selección actual
        modeloEntregados.clear();

        for (Pedido p : pedidos) {
            if (p.getEstado() instanceof Entregado) {
                modeloEntregados.addElement(p);
            }
        }

        // Restaurar selección si aún existe en la lista
        if (seleccionado != null && modeloEntregados.contains(seleccionado)) {
            listaPedidos.setSelectedValue(seleccionado, true);
        }
    }

    private void pagarPedido() {
        Pedido seleccionado = listaPedidos.getSelectedValue();
        FormaPago forma = (FormaPago) comboPago.getSelectedItem();

        if (seleccionado != null && forma != null) {
            FachadaPago fachada = new FachadaPago();
            fachada.procesarPago(seleccionado, forma);

            modeloEntregados.removeElement(seleccionado);
            JOptionPane.showMessageDialog(this, "✅ Pedido pagado exitosamente.");
        }
    }

    private static class PedidoRenderer extends DefaultListCellRenderer {
        @Override
        public Component getListCellRendererComponent(
                JList<?> list, Object value, int index,
                boolean isSelected, boolean cellHasFocus) {

            Component c = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

            if (value instanceof Pedido) {
                Pedido p = (Pedido) value;
                setText(p.getDescripcion() + " | Total: $" + p.calcularTotal());
            }
            return c;
        }
    }

    public void setMediador(Mediador mediador) {
        this.mediador = mediador;
    }
}