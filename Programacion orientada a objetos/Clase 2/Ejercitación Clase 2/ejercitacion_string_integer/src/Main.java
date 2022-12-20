public class Main {
    public static void main(String[] args) {
        // Ejercicio 1
        String texto1 = "Hola";
        String texto2 = "Mundo";
        if (texto1.equals(texto2)){
            System.out.println("El texto '" + texto1 + "' es igual a '" + texto2 + "'");
        } else {
            System.out.println("El texto '" + texto1 + "' no es igual a '" + texto2 + "'");
        }
        // Ejercicio 2
        Integer numero1 = 1;
        Integer numero2 = 1;
        if (numero1.compareTo(numero2) > 0){
            System.out.println("El numero " + numero1 + " es mayor a " + numero2);
        } else if (numero1.compareTo(numero2) < 0){
            System.out.println("El numero " + numero1 + " es menor a " + numero2);
        } else {
            System.out.println("El numero " + numero1 + " es igual a " + numero2);
        }
    }
}