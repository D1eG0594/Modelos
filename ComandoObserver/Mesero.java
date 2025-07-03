import java.util.ArrayList;
import java.util.List;

public class Mesero {
    private List<Observador> observadores = new ArrayList<>();

    public void agregarObservador(Observador obs){
        observadores.add(obs);
    }
    public void tomarPedido(Comando pedido){
        notificarObservadores(pedido);
    }

    private void notificarObservadores(Comando pedido){
        for (Observador obs:observadores){
            obs.actualizar(pedido);
        }
    }
}
