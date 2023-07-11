public class Service implements IService{
    AuthenticationService authenticationService;
    CuentaService cuentaService;
    CajaService cajaService;
    @Override
    public void procesarRetiro(String DNI, String contrasenia, Double saldoARetirar) {
        boolean esUsuarioValido = authenticationService.validarUsuarioYContrasenia(DNI, contrasenia);
        if (esUsuarioValido){
            Cuenta cuenta = cuentaService.getCuenta(DNI);
            if (cuenta.getSaldoActual() >= saldoARetirar){
                cuenta.setSaldoActual(cuenta.getSaldoActual()- saldoARetirar);
                Double dineroEntregado = cajaService.entregarDinero(saldoARetirar);
                System.out.println("El dinero entregado fue de " + dineroEntregado);
            } else {
                System.out.println("Saldo insuficiente");
            }
        }
    }

    public void setAuthenticationService(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    public void setCuentaService(CuentaService cuentaService) {
        this.cuentaService = cuentaService;
    }

    public void setCajaService(CajaService cajaService) {
        this.cajaService = cajaService;
    }
}
