public class Camion implements Strategy{
    @Override
    public void acelerar() {
        System.out.println("Acelerando como camión");
    }

    @Override
    public void frenar() {
        System.out.println("Frenando como camión");
    }
}
