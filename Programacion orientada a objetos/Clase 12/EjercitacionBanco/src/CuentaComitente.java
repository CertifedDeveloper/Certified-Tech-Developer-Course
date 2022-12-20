public class CuentaComitente extends Cuenta{
    private String CNV;

    public CuentaComitente(Cliente cliente, String CNV) {
        super(cliente);
        this.CNV = CNV;
    }

    public CuentaComitente(Cliente cliente) {
        super(cliente);
    }

    @Override
    public void depositarEfectivo(double monto){
        setSaldo(monto * 0.99);
    }
    @Override
    public void extraerEfectivo(double monto){
        if (CNV == null){
            setSaldo(getSaldo() - monto * 0.5);
        }else if (CNV.equals("")){
            setSaldo(getSaldo() - monto * 0.5);
        }
        else{
            setSaldo(getSaldo() - monto);
        }
    }
}
