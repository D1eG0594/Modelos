package main;

import interfaz.*;
import mediador.MediadorRestaurante;
import sistema.Restaurante;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            // Crear vistas
            VistaChef vistaChef = new VistaChef();
            VistaMesero vistaMesero = new VistaMesero();
            VistaPago vistaPago = new VistaPago();
            VistaHistorial vistaHistorial = new VistaHistorial();
            InterfazPedido interfazAgregar = new InterfazPedido();

            // Crear Mediador
            MediadorRestaurante mediador = new MediadorRestaurante();
            mediador.setChef(vistaChef);
            mediador.setMesero(vistaMesero);
            mediador.setPago(vistaPago);
            mediador.setHistorial(vistaHistorial);

            // Registrar mediador en las vistas que lo usan
            vistaChef.setMediador(mediador);
            vistaMesero.setMediador(mediador);
            vistaPago.setMediador(mediador);
            interfazAgregar.setMediador(mediador);

            // Registrar vistas como observadores del restaurante
            Restaurante restaurante = Restaurante.getInstance();
            restaurante.agregarObservador(vistaChef);
            restaurante.agregarObservador(vistaMesero);
            restaurante.agregarObservador(vistaPago);

            // Armar interfaz gráfica
            JTabbedPane tabs = new JTabbedPane();
            tabs.addTab("Agregar Pedido", interfazAgregar);
            tabs.addTab("Pedidos Mesero", vistaMesero);
            tabs.addTab("Cocina (Chef)", vistaChef);
            tabs.addTab("Pago", vistaPago);
            tabs.addTab("Historial", vistaHistorial);

            // 👉 Este listener detecta cuando el usuario cambia de pestaña
            tabs.addChangeListener(e -> {
                int index = tabs.getSelectedIndex();
                String title = tabs.getTitleAt(index);
                if (title.equals("Historial")) {
                    vistaHistorial.mostrarHistorial();
                }
            });

            JFrame ventana = new JFrame("Sistema de Restaurante");
            ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            ventana.setSize(800, 600);
            ventana.add(tabs);
            ventana.setVisible(true);
        });
    }
}