import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Cuenta cuentaA = new Cuenta(1, 1000);
        Cuenta cuentaB = new Cuenta(2, 500);
        Cuenta cuentaC = new Cuenta(3, 100);
        ArrayList<Cuenta> cuentas = new ArrayList<>();
        cuentas.add(cuentaB);
        cuentas.add(cuentaC);
        cuentas.add(cuentaA);
        Persona persona = new Persona("Juan", "Perez", 100, cuentas);
        if (persona.esMayorEdad()){
            System.out.println(persona.getNombreCompleto() + " es mayor de edad");
        } else{
            System.out.println(persona.getNombreCompleto() + " no es mayor de edad");
        }
        System.out.println("-----------------------------------------------------------");
        System.out.println("El saldo total de "+ persona.getNombreCompleto() + " es de " + persona.getSaldoTotal());
        System.out.println("-----------------------------------------------------------");
        System.out.println("Consulta de saldos de " + persona.getNombreCompleto());
        persona.mostrarCuentas();
    }
}