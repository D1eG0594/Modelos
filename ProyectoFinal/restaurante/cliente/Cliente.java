package cliente;

import pedido.Pedido;
import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private String nombre;
    private List<Pedido> pedidos = new ArrayList<>();

    public Cliente(String nombre) {
        this.nombre = nombre;
    }

    public void agregarPedido(Pedido pedido){
        pedidos.add(pedido);
    }
    

    public String getNombre() {
        return nombre;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }
}

