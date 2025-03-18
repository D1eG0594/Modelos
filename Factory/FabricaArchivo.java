public class FabricaArchivo implements FabricaAbstracta {

    @Override
    public Entrada crearEntrada() {
        return new EntradaArchivo();
    }

    @Override
    public Salida crearSalida() {
        return new SalidaArchivo();
    }
    
    
}
