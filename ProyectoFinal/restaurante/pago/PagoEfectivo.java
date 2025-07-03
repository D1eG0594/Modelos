package pago;
import salida.*;

public class PagoEfectivo extends PagoTemplate {
    private Salida salidaConsola = new SalidaConsola();
    private SalidaGUI salidaGUI = new SalidaGUI();

    public void pagar(double monto) {
        verificarMonto(monto);
        realizarTransaccion(monto);
        imprimirRecibo(monto);
    }

    public String toString() {
        return "Efectivo";
    }

    @Override
    protected void realizarTransaccion(double monto) {
        salidaConsola.enviar("Realizando pago en efectivo de $" + monto);
        salidaGUI.enviar("Realizando pago en efectivo de $" + monto);
    }
}
