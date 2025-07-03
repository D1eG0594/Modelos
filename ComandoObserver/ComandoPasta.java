public class ComandoPasta implements Comando {
    private Chef chef;
    public ComandoPasta(Chef chef){
        this.chef = chef;
    }

    @Override
    public void execute(){
        chef.prepararPasta();
    }
}
