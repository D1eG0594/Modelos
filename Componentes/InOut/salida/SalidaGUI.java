package salida;

import javax.swing.JOptionPane;

public class SalidaGUI implements Salida {
    @Override
    public void enviar(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje);
    }
}