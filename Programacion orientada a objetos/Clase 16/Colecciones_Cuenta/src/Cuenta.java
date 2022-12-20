public class Cuenta implements Comparable<Cuenta>{
    private int nroCuenta;
    private double saldo;

    public Cuenta(int nroCuenta, double saldo) {
        this.nroCuenta = nroCuenta;
        this.saldo = saldo;
    }

    public double getSaldo() {
        return saldo;
    }

    public int getNroCuenta() {
        return nroCuenta;
    }

    @Override
    public int compareTo(Cuenta o) {
        int resultado = 0;
        if (nroCuenta > o.nroCuenta) resultado = 1;
        if (nroCuenta < o.nroCuenta) resultado = -1;
        return resultado;
    }

    @Override
    public String toString() {
        return "Nro de Cuenta: " + nroCuenta + "\n" +
                "Saldo: " + saldo;
    }
}
