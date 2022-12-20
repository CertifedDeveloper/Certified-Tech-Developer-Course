public class Main {
    public static void main(String[] args) {
        SuperChofer choferA = new SuperChofer("ChoferA", "Camion");
        choferA.acelerar();
        choferA.frenar();
        System.out.println("------------------------------------------------------------------");
        SuperChofer choferB = new SuperChofer("ChoferB","Auto");
        choferB.acelerar();
        choferB.frenar();
    }
}