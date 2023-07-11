import java.util.ArrayList;

public class CuentaService {
    ArrayList<Cuenta> cuentas;

    public CuentaService() {
        this.cuentas = new ArrayList<>();
    }

    public Cuenta getCuenta(String DNI){
        Cuenta cuentaABuscar = null;
        for (Cuenta cuenta : cuentas){
            if (cuenta.getDNI().equalsIgnoreCase(DNI)){
                cuentaABuscar = cuenta;
            }
        }
        return cuentaABuscar;
    }
    public void agregarCuenta(Cuenta cuenta){
        cuentas.add(cuenta);
    }
}
