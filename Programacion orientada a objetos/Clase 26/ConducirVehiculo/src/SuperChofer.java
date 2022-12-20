public class SuperChofer {
    private String nombre;
    private String vehiculo;
    private Strategy estrategia;

    public SuperChofer(String nombre, String vehiculo) throws RuntimeException{
        this.nombre = nombre;
        this.vehiculo = vehiculo;
        switch (vehiculo){
            case "Auto":
                estrategia = new Auto();
                break;
            case "Camion":
                estrategia = new Camion();
                break;
            case "Moto":
                estrategia = new Moto();
                break;
            case "Lancha":
                estrategia = new Lancha();
                break;
            case "Barco":
                estrategia = new Barco();
            default:
                throw new RuntimeException("El vehiculo no se puede manejar");
        }
    }
    public void acelerar(){
        System.out.println("Super Chofer: " + nombre);
        estrategia.acelerar();
    }
    public void frenar(){
        System.out.println("Super Chofer: " + nombre);
        estrategia.frenar();
    }
}
