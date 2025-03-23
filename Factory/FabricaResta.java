public class FabricaResta extends FabricaOperaciones {
    
    @Override
    public Operacion crearOperacion() {
        return new Resta();
    }
    
}
