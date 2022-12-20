public class Main {
    public static void main(String[] args) {
        Capitan capitan = new Capitan("Nombre", "apellido", "123abc");
        Embarcacion embarcacionA = new Yate(2021, 100, capitan,5);
        Embarcacion embarcacionB = new Yate(2000, 100, capitan,7);
        Embarcacion embarcacionC = new Velero(2000,50,capitan,5);
        double alquilerA = embarcacionA.calcularAlquiler();
        System.out.println("El alquiler de la embarcación A es: " + alquilerA);
        double alquilerB = embarcacionB.calcularAlquiler();
        System.out.println("El alquiler de la embarcación B es: " + alquilerB);
        double alquilerC = embarcacionC.calcularAlquiler();
        System.out.println("El alquiler de la embarcación C es: " + alquilerC);
        ((Yate)embarcacionA).comparar((Yate)embarcacionB);
        ((Velero)embarcacionC).evaluar();
    }
}