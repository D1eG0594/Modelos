package pago;

import salida.Salida;

public class AdaptadorImpresora implements Salida {

    private ImpresoraTickets impresora = new ImpresoraTickets();

    @Override
    public void enviar(String mensaje) {
        impresora.imprimirTicket(mensaje);
    }
    
}

