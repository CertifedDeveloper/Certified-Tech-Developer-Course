import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Cliente cliente = new Cliente(1,"Apellido", "12345", "12345");
        Cuenta nuevaCuentaAhorro = new CuentaAhorro(cliente, 0.2);
        Cuenta nuevaCuentaCorriente = new CuentaCorriente(cliente,1000.);
        System.out.println("Saldos iniciales");
        nuevaCuentaAhorro.informarSaldo();
        nuevaCuentaCorriente.informarSaldo();
        System.out.println("----------------------------------------------------");
        System.out.println("Saldos después de depositar efectivo");
        nuevaCuentaAhorro.depositarEfectivo(100.);
        nuevaCuentaCorriente.depositarEfectivo(50.);
        nuevaCuentaAhorro.informarSaldo();
        nuevaCuentaCorriente.informarSaldo();
        System.out.println("----------------------------------------------------");
        System.out.println("Saldos después de depositar cheque en cuenta corriente");
        Cheque cheque = new Cheque(50., "Banco", LocalDate.of(1900,1,1));
        ((CuentaCorriente) nuevaCuentaCorriente).depositarCheque(cheque);
        nuevaCuentaAhorro.informarSaldo();
        nuevaCuentaCorriente.informarSaldo();
        System.out.println("----------------------------------------------------");
        System.out.println("Saldos después de extraer efectivo");
        nuevaCuentaAhorro.extraerEfectivo(50.);
        nuevaCuentaCorriente.extraerEfectivo(50.);
        nuevaCuentaAhorro.informarSaldo();
        nuevaCuentaCorriente.informarSaldo();
        System.out.println("----------------------------------------------------");
        System.out.println("Saldos después de extraer efectivo de la cuenta de ahorro con un monto mayor al saldo actual");
        nuevaCuentaAhorro.extraerEfectivo(100.);
        nuevaCuentaCorriente.extraerEfectivo(100.);
        nuevaCuentaAhorro.informarSaldo();
        nuevaCuentaCorriente.informarSaldo();
        System.out.println("----------------------------------------------------");
        System.out.println("Saldos después de extraer efectivo de la cuenta corriente con un monto mayor al saldo actual más descubierto");
        nuevaCuentaCorriente.extraerEfectivo(2000.);
        nuevaCuentaAhorro.informarSaldo();
        nuevaCuentaCorriente.informarSaldo();
        System.out.println("----------------------------------------------------");
        System.out.println("Saldos después de cobrar intereses de la cuenta de ahorro");
        ((CuentaAhorro)nuevaCuentaAhorro).cobrarIntereses();
        nuevaCuentaAhorro.informarSaldo();
        nuevaCuentaCorriente.informarSaldo();
    }
}