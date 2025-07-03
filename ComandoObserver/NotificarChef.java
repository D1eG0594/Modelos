public class NotificarChef implements Observador {
    @Override
    public void actualizar(Comando pedido){
        pedido.execute();
    }
}
