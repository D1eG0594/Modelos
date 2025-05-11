import java.util.ArrayList;
import java.util.List;

// Interfaz común para todos los vehículos
interface Vehiculo {
    void mover(int x, int y);
    int getPosX();
    int getPosY();
    double getPeso();
}

// Clase Carro
class Carro implements Vehiculo {
    private int x, y;
    private double peso;

    public Carro(int x, int y, double peso) {
        this.x = x;
        this.y = y;
        this.peso = peso;
    }

    @Override
    public void mover(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int getPosX() { return x; }

    @Override
    public int getPosY() { return y; }

    @Override
    public double getPeso() { return peso; }

    @Override
    public String toString() {
        return "Carro en (" + x + ", " + y + "), peso: " + peso;
    }
}

// Clase Camion (Composite)
class Camion implements Vehiculo {
    private int x, y;
    private double pesoBase;
    private List<Vehiculo> cargados;

    public Camion(int x, int y, double pesoBase) {
        this.x = x;
        this.y = y;
        this.pesoBase = pesoBase;
        this.cargados = new ArrayList<>();
    }

    public void cargarVehiculo(Vehiculo v) {
        v.mover(x, y); // Alinea posición con el camión
        cargados.add(v);
    }

    public void descargarVehiculo(Vehiculo v) {
        cargados.remove(v);
    }

    @Override
    public void mover(int x, int y) {
        this.x = x;
        this.y = y;
        for (Vehiculo v : cargados) {
            v.mover(x, y);
        }
    }

    @Override
    public int getPosX() { return x; }

    @Override
    public int getPosY() { return y; }

    @Override
    public double getPeso() {
        double total = pesoBase;
        for (Vehiculo v : cargados) {
            total += v.getPeso();
        }
        return total;
    }

    @Override
    public String toString() {
        return "Camión en (" + x + ", " + y + "), peso total: " + getPeso() + ", vehículos cargados: " + cargados.size();
    }
}

// Clase Main para probar el funcionamiento
public class PruebaComposite {
    public static void main(String[] args) {
        Carro carro1 = new Carro(5, 10, 1000);
        Carro carro2 = new Carro(15, 20, 1200);
        Camion camion = new Camion(0, 0, 5000);

        System.out.println("Antes de cargar:");
        System.out.println(carro1);
        System.out.println(carro2);
        System.out.println(camion);

        camion.cargarVehiculo(carro1);
        camion.cargarVehiculo(carro2);

        System.out.println("\nDespués de cargar:");
        System.out.println(carro1);
        System.out.println(carro2);
        System.out.println(camion);

        camion.mover(100, 200);

        System.out.println("\nDespués de mover el camión:");
        System.out.println(carro1);
        System.out.println(carro2);
        System.out.println(camion);

        camion.descargarVehiculo(carro1);
        carro1.mover(50, 60); // Mover el carro después de descargarlo  

        System.out.println("\nDespués de descargar un carro:");
        System.out.println(carro1);
        System.out.println(carro2);
        System.out.println(camion);
    }
}
