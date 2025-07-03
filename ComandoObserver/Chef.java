public class Chef {
    private String nombre;

    public Chef(String nombre){
        this.nombre = nombre;
    }

    public void prepararPizza(){
        System.out.println(nombre + " esta preparando una pizza.");
    }

    public void prepararPasta(){
        System.out.println(nombre + " esta preparando pasta.");
    }
}

