public class CuentaCorriente extends  Cuenta{
    private double descubierto;

    public CuentaCorriente(Cliente cliente, double descubierto) {
        super(cliente);
        this.descubierto = descubierto;
    }

    @Override
    public void extraerEfectivo(double monto){
        if (monto <= getSaldo()){
            setSaldo(getSaldo() - monto);
        } else {
            if (monto <= descubierto + getSaldo()){
                setSaldo(0.);
            } else {
                System.out.println("Monto a extraer supera su saldo actual más el descubierto");
            }
        }
    }
    public void depositarCheque(Cheque c){
        setSaldo(getSaldo() + c.getMonto());
    }
}
