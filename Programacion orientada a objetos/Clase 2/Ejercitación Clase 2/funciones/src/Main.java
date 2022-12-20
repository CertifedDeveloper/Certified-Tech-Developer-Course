public class Main {
    public static void main(String[] args) {
        boolean divisibilidad = esDivisible(10, 2);
        System.out.println(divisibilidad);
    }
    static boolean esDivisible(int n, int divisor){
        return n % divisor == 0;
    }
}