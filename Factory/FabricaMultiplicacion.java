public class FabricaMultiplicacion extends FabricaOperaciones {
    
    @Override
    public Operacion crearOperacion() {
        return new Multiplicacion();
    }
    
}
