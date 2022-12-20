public class Velero extends  Embarcacion implements Evaluable{
    private int cantidadMastiles;

    public Velero(int anioFabricacion, double eslora, Capitan capitan, int cantidadMastiles) {
        super(anioFabricacion, eslora, capitan);
        this.cantidadMastiles = cantidadMastiles;
    }

    @Override
    public void evaluar() {
        if (this.cantidadMastiles > 4){
            System.out.println("El velero es grande");
        } else{
            System.out.println("El velero no es grande");
        }
    }
}
