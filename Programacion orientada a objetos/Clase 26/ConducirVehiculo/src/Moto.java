public class Moto implements Strategy{
    @Override
    public void acelerar() {
        System.out.println("Acelerando como moto");
    }

    @Override
    public void frenar() {
        System.out.println("Frenando como moto");
    }
}
