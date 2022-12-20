public class Yate extends Embarcacion implements Comparable{
    private int cantidadCamarotes;

    public Yate(int anioFabricacion, double eslora, Capitan capitan, int cantidadCamarotes) {
        super(anioFabricacion, eslora, capitan);
        this.cantidadCamarotes = cantidadCamarotes;
    }

    @Override
    public void comparar(Object o) {
        Yate y2 = (Yate) o;
        if (this.cantidadCamarotes > y2.cantidadCamarotes){
            System.out.println("El yate a comparar es más pequeño");
        } else if(this.cantidadCamarotes  < y2.cantidadCamarotes){
            System.out.println("El yate a comparar es más grande");
        } else{
            System.out.println("Ambos yates son de igual tamaño");
        }
    }
}
