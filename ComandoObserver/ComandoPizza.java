public class ComandoPizza implements Comando {
    private Chef chef;
    public ComandoPizza(Chef chef){
        this.chef = chef;
    }

    @Override
    public void execute(){
        chef.prepararPizza();
    }
}
