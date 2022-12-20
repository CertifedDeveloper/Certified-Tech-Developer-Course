public abstract class Cuenta {
    private double saldo;
    private Cliente cliente;

    public Cuenta(Cliente cliente) {
        this.cliente = cliente;
        saldo = 0.;
    }
    public void depositarEfectivo(double monto){
        saldo += monto;
    }
    public abstract void extraerEfectivo(double monto);
    public void informarSaldo(){
        System.out.println("Su saldo actual es de "+ saldo);
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
}
