public class Cuenta {
    private String DNI;
    private Double saldoActual;

    public String getDNI() {
        return DNI;
    }

    public Double getSaldoActual() {
        return saldoActual;
    }

    public void setSaldoActual(Double saldoActual) {
        this.saldoActual = saldoActual;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }
}
