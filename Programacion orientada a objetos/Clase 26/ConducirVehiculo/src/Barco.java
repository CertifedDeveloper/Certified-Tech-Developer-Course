public class Barco implements Strategy{
    @Override
    public void acelerar() {
        System.out.println("Acelerando como barco");
    }

    @Override
    public void frenar() {
        System.out.println("Frenando como barco");
    }
}
