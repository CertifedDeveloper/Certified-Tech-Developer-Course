public class Lancha implements Strategy{
    @Override
    public void acelerar() {
        System.out.println("Acelerando como lancha");
    }

    @Override
    public void frenar() {
        System.out.println("Frenando como lancha");
    }
}
