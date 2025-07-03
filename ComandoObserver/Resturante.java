public class Resturante {
    public static void main(String[] args) {
        Chef chef = new Chef("Juan");

        Comando pedidoPizza = new ComandoPizza(chef);
        Comando pedidoPasta = new ComandoPasta(chef);

        Mesero mesero = new Mesero();
        Observador notificador = new NotificarChef();

        mesero.agregarObservador(notificador);
        mesero.tomarPedido(pedidoPasta);
        mesero.tomarPedido(pedidoPizza);
    }
}
