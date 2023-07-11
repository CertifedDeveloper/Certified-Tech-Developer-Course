public class Main {
    public static void main(String[] args) {
        Service servicio = new Service();
        AuthenticationService autenticacion = new AuthenticationService();
        CuentaService cuentaService = new CuentaService();
        CajaService cajaService = new CajaService();
        Cuenta cuenta = new Cuenta();

        autenticacion.agregarUsuarioYContrasenia("1234", "1234");
        cuenta.setDNI("1234");
        cuenta.setSaldoActual(1000.);
        cuentaService.agregarCuenta(cuenta);
        servicio.setAuthenticationService(autenticacion);
        servicio.setCuentaService(cuentaService);
        servicio.setCajaService(cajaService);

        servicio.procesarRetiro("1234", "1234", 500.);
    }
}