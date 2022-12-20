public class Main {
    public static void main(String[] args) {
        Empresa empresa = new Empresa();
        Reserva reservaA = new Reserva("1", 50, new Recorrido(new Estacion("Bragado"), new Estacion("Buenos Aires")));
        Reserva reservaB = new Reserva("2", 100, new Recorrido(new Estacion("Mercedes"), new Estacion("Buenos Aires")));
        empresa.agregarReserva(reservaA);
        empresa.agregarReserva(reservaB);
        System.out.println(reservaA.calcularPrecio());
        System.out.println(reservaB.calcularPrecio());
        System.out.println(empresa.recaudarTotal());
        try{
            System.out.println(empresa.calcularCantidadRecorrida(new Estacion("Buenos Aires")));
        } catch (CustomException customException){
            System.out.println(customException);
        }
        try{
            System.out.println(empresa.calcularCantidadRecorrida(new Estacion("Hello")));
        } catch (CustomException customException){
            System.out.println(customException);
        }
    }
}