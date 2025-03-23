public class FabricaDivision extends FabricaOperaciones {
    
    @Override
    public Operacion crearOperacion() {
        return new Division();
    }
    
}
