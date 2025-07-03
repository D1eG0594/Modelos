package pago;

import salida.*;


public class PagoTarjeta extends PagoTemplate {
    private Salida salidaConsola = new SalidaConsola();
    private SalidaGUI salidaGUI = new SalidaGUI();

    public void pagar(double monto) {
        verificarMonto(monto);
        realizarTransaccion(monto);
        imprimirRecibo(monto);
    }

    public String toString() {
        return "Tarjeta";
    }

    @Override
    protected void realizarTransaccion(double monto) {
        salidaConsola.enviar("Realizando pago con tarjeta de $" + monto);
        salidaGUI.enviar("Realizando pago con tarjeta de $" + monto);
    }
}
