public class CuentaAhorro extends  Cuenta{
    private double tasaInteres;

    public CuentaAhorro(Cliente cliente, double tasaInteres) {
        super(cliente);
        this.tasaInteres = tasaInteres;
    }

    public void cobrarIntereses(){
        setSaldo(getSaldo() * (1 + tasaInteres));
    }

    @Override
    public void extraerEfectivo(double monto){
        if (monto <= getSaldo()){
            setSaldo(getSaldo() - monto);
        } else {
            System.out.println("Monto a extraer supera su saldo actual");
        }
    }
}
