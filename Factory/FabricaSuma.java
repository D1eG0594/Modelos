public class FabricaSuma extends FabricaOperaciones {
    
    @Override
    public Operacion crearOperacion() {
        return new Suma();
    }

}
