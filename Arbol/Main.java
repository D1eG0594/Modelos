import java.util.ArrayList;
import java.util.List;


interface Prototipo<T> {
    T clonar();
}

//  Nivel 3: Clase Hoja
class Hoja implements Prototipo<Hoja> {
    private String color;

    public Hoja(String color) {
        this.color = color;
    }

    @Override
    public Hoja clonar() {
        return new Hoja(this.color);
    }

    @Override
    public String toString() {
        return "Hoja de color " + color;
    }
}

//  Nivel 2: Clase Rama
class Rama implements Prototipo<Rama> {
    private List<Hoja> hojas = new ArrayList<>();

    public void agregarHoja(Hoja hoja) {
        hojas.add(hoja);
    }

    @Override
    public Rama clonar() {
        Rama ramaClonada = new Rama();
        for (Hoja hoja : this.hojas) {
            ramaClonada.agregarHoja(hoja.clonar()); // Clonación profunda
        }
        return ramaClonada;
    }

    @Override
    public String toString() {
        return "Rama con hojas: " + hojas;
    }
}

//  Nivel 1: Clase Árbol
class Arbol implements Prototipo<Arbol> {
    private List<Rama> ramas = new ArrayList<>();

    public void agregarRama(Rama rama) {
        ramas.add(rama);
    }

    @Override
    public Arbol clonar() {
        Arbol arbolClonado = new Arbol();
        for (Rama rama : this.ramas) {
            arbolClonado.agregarRama(rama.clonar()); // Clonación profunda
        }
        return arbolClonado;
    }

    @Override
    public String toString() {
        return "Árbol con ramas: " + ramas;
    }
}

//  Prueba del patrón Prototype con la interfaz genérica
public class Main {
    public static void main(String[] args) {
        // Crear un árbol original
        Arbol arbol = new Arbol();
        Rama rama1 = new Rama();
        rama1.agregarHoja(new Hoja("Verde"));
        rama1.agregarHoja(new Hoja("Rojo"));
        arbol.agregarRama(rama1);

        // Clonar el árbol
        Arbol arbolClonado = arbol.clonar();

        // Mostrar resultados
        System.out.println("Árbol original: " + arbol);
        System.out.println("Árbol clonado: " + arbolClonado);
    }
}
