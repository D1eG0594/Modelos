package interfaz;

import producto.*;
import pedido.*;
import bd.*;
import chain.ManejadorPedido;
import chain.ValidarProductos;
import chain.ValidarTotal;
import command.Comando;
import command.ConfirmarPedidoCommand;
import salida.*;
import mediador.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;

public class InterfazPedido extends JPanel {
    private JComboBox<String> comboProductos;
    private DefaultListModel<String> listaPedidoModel;
    private JList<String> listaPedido; // <- ahora es atributo
    private JLabel totalLabel;
    private PedidoBuilder pedidoBuilder;
    private Salida salida;
    private FabricaProductoProxy proxy;
    private Mediador mediador;

    private Pedido ultimoPedidoConfirmado;

    private JCheckBox cbQueso, cbHielo, cbSalsaPicante, cbTocineta, cbSalsaDeTomate;

    public InterfazPedido() {
        this.salida = new SalidaConsola();
        this.proxy = new FabricaProductoProxy(salida);
        this.pedidoBuilder = new PedidoBuilder();

        setLayout(new BorderLayout());

        JPanel panelSeleccion = new JPanel();
        comboProductos = new JComboBox<>();
        cargarProductos();
        JButton btnAgregar = new JButton("Agregar al pedido");
        JButton btnClonar = new JButton("Clonar Último Pedido");

        panelSeleccion.add(new JLabel("Producto:"));
        panelSeleccion.add(comboProductos);

        cbQueso = new JCheckBox("Queso Extra");
        cbHielo = new JCheckBox("Hielo");
        cbSalsaPicante = new JCheckBox("Salsa Picante");
        cbTocineta = new JCheckBox("Tocineta");
        cbSalsaDeTomate = new JCheckBox("Salsa de Tomate");

        panelSeleccion.add(cbQueso);
        panelSeleccion.add(cbHielo);
        panelSeleccion.add(cbSalsaPicante);
        panelSeleccion.add(cbTocineta);
        panelSeleccion.add(cbSalsaDeTomate);
        panelSeleccion.add(btnAgregar);
        panelSeleccion.add(btnClonar);

        listaPedidoModel = new DefaultListModel<>();
        listaPedido = new JList<>(listaPedidoModel);
        JScrollPane scroll = new JScrollPane(listaPedido);

        JButton btnEliminar = new JButton("Eliminar producto"); // <- nuevo botón
        btnEliminar.addActionListener(e -> eliminarProductoSeleccionado());

        JPanel panelCentro = new JPanel(new BorderLayout());
        panelCentro.add(scroll, BorderLayout.CENTER);
        panelCentro.add(btnEliminar, BorderLayout.SOUTH);

        JPanel panelInferior = new JPanel();
        totalLabel = new JLabel("Total: $0.0");
        JButton btnConfirmar = new JButton("Confirmar Pedido");

        panelInferior.add(totalLabel);
        panelInferior.add(btnConfirmar);

        JPanel panelRegistro = new JPanel(new GridLayout(6, 1));
        JTextField txtNombre = new JTextField();
        JTextField txtPrecio = new JTextField();
        JButton btnRegistrar = new JButton("Registrar Producto");

        panelRegistro.setBorder(BorderFactory.createTitledBorder("Agregar Producto"));
        panelRegistro.add(new JLabel("Nombre:"));
        panelRegistro.add(txtNombre);
        panelRegistro.add(new JLabel("Precio:"));
        panelRegistro.add(txtPrecio);
        panelRegistro.add(btnRegistrar);

        // Acciones
        btnAgregar.addActionListener(e -> agregarProductoConExtras());
        btnConfirmar.addActionListener(e -> confirmarPedido());
        btnClonar.addActionListener(e -> clonarUltimoPedido());

        btnRegistrar.addActionListener(e -> {
            String nombre = txtNombre.getText();
            double precio;
            try {
                precio = Double.parseDouble(txtPrecio.getText());
                if (proxy.registrarProducto(nombre, precio)) {
                    comboProductos.removeAllItems();
                    cargarProductos();
                    txtNombre.setText("");
                    txtPrecio.setText("");
                }
            } catch (NumberFormatException ex) {
                salida.enviar("❌ Precio inválido.");
            }
        });

        add(panelSeleccion, BorderLayout.NORTH);
        add(panelCentro, BorderLayout.CENTER); // <- actualizamos aquí
        add(panelInferior, BorderLayout.SOUTH);
        add(panelRegistro, BorderLayout.EAST);
    }

    private void cargarProductos() {
        List<ProductoBase> productos = FabricaProducto.obtenerTodos();
        for (ProductoBase p : productos) {
            comboProductos.addItem(p.getDescripcion());
        }
    }

    private void agregarProductoConExtras() {
        String nombre = (String) comboProductos.getSelectedItem();
        Producto p = FabricaProducto.crearProductoPorNombre(nombre);
        if (p == null) {
            salida.enviar("❌ Error: producto no encontrado.");
            return;
        }

        if (cbQueso.isSelected()) p = new ExtraQueso(p);
        if (cbHielo.isSelected()) p = new Hielo(p);
        if (cbSalsaPicante.isSelected()) p = new SalsaPicante(p);
        if (cbTocineta.isSelected()) p = new Tocineta(p);
        if (cbSalsaDeTomate.isSelected()) p = new SalsaDeTomate(p);

        pedidoBuilder.agregarProducto(p);
        listaPedidoModel.addElement(p.getDescripcion() + " - $" + p.getPrecio());
        totalLabel.setText("Total: $" + pedidoBuilder.calcularTotal());

        cbQueso.setSelected(false);
        cbHielo.setSelected(false);
        cbSalsaPicante.setSelected(false);
        cbTocineta.setSelected(false);
        cbSalsaDeTomate.setSelected(false);
    }

    private void confirmarPedido() {
        Pedido pedido = pedidoBuilder.build();

        ManejadorPedido inicioCadena = new ValidarProductos();
        inicioCadena.enlazarSiguiente(new ValidarTotal());

        if (inicioCadena.procesar(pedido)) {
            Comando confirmar = new ConfirmarPedidoCommand(pedido);
            confirmar.ejecutar();

            salida.enviar("\n✅ Pedido confirmado:");
            for (Producto p : pedido.getProductos()) {
                salida.enviar("- " + p.getDescripcion() + " ($" + p.getPrecio() + ")");
            }
            salida.enviar("TOTAL FINAL: $" + pedido.calcularTotal());

            ultimoPedidoConfirmado = pedido;
            pedidoBuilder = new PedidoBuilder();
            listaPedidoModel.clear();
            totalLabel.setText("Total: $0.0");
        }
    }

    private void clonarUltimoPedido() {
        if (ultimoPedidoConfirmado == null) {
            salida.enviar("⚠️ No hay pedido anterior para clonar.");
            return;
        }

        Pedido clon = ultimoPedidoConfirmado.clone();
        for (Producto p : clon.getProductos()) {
            pedidoBuilder.agregarProducto(p);
            listaPedidoModel.addElement(p.getDescripcion() + " - $" + p.getPrecio());
        }

        totalLabel.setText("Total: $" + pedidoBuilder.calcularTotal());
        salida.enviar("✅ Pedido clonado correctamente.");
    }

    private void eliminarProductoSeleccionado() {
        int index = listaPedido.getSelectedIndex();
        if (index >= 0) {
            pedidoBuilder.eliminarProducto(index);
            listaPedidoModel.remove(index);
            totalLabel.setText("Total: $" + pedidoBuilder.calcularTotal());
            salida.enviar("🗑 Producto eliminado del pedido.");
        } else {
            salida.enviar("⚠️ Debe seleccionar un producto para eliminar.");
        }
    }

    public void setMediador(Mediador mediador) {
        this.mediador = mediador;
    }
}