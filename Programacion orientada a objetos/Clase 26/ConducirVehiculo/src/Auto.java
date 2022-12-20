public class Auto implements Strategy{
    @Override
    public void acelerar() {
        System.out.println("Acelerando como auto");
    }

    @Override
    public void frenar() {
        System.out.println("Frenando como auto");
    }
}
