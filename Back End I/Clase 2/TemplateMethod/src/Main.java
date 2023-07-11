import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        TarjetaDebito tarjetaDebito = new TarjetaDebito("12345","123", LocalDate.of(2000,1,1), 500.);
        TarjetaCredito tarjetaCredito = new TarjetaCredito("12345","123", LocalDate.of(2000,1,1), 1000., 500.);
        TarjetaDebito tarjetaDebitoB = new TarjetaDebito("12345","123", LocalDate.of(3000,1,1), 500.);
        TarjetaCredito tarjetaCreditoB = new TarjetaCredito("12345","123", LocalDate.of(3000,1,1), 1000., 500.);
        ProcesadorDebito procesadorDebito = new ProcesadorDebito();
        ProcesadorCredito procesadorCredito = new ProcesadorCredito();
        procesadorDebito.procesarPago(tarjetaDebito,200.);
        procesadorCredito.procesarPago(tarjetaCredito, 500.);
        procesadorDebito.procesarPago(tarjetaDebitoB,200.);
        procesadorCredito.procesarPago(tarjetaCreditoB, 500.);
        procesadorDebito.procesarPago(tarjetaDebitoB,1000.);
        procesadorCredito.procesarPago(tarjetaCreditoB, 2000.);
    }
}