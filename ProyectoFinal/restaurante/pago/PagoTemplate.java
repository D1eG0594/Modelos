package pago;

import salida.*;

public abstract class PagoTemplate implements FormaPago {
    private Salida salidaConsola = new SalidaConsola();
    private Salida salidaGUI = new SalidaGUI();
    private Salida adaptadorImpresora = new AdaptadorImpresora();
    @Override
    public void pagar(double monto) {
        verificarMonto(monto);
        realizarTransaccion(monto);
        imprimirRecibo(monto);
    }

    protected abstract void realizarTransaccion(double monto);
    protected void verificarMonto(double monto) {
        salidaConsola.enviar("Verificando monto: $" + monto);
        salidaGUI.enviar("Verificando monto: $" + monto);
    }
    protected void imprimirRecibo(double monto) {
        adaptadorImpresora.enviar("Pago de $" + monto + " realizado exitosamente.");
        salidaGUI.enviar("Pago de $" + monto + " realizado exitosamente.");
    }
}


