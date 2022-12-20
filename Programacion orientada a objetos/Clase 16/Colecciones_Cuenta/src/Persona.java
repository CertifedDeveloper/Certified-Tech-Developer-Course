import java.util.ArrayList;
import java.util.Comparator;

public class Persona {
    private String nombre;
    private String apellido;
    private int edad;
    private ArrayList<Cuenta> cuentas;

    public Persona(String nombre, String apellido, int edad, ArrayList<Cuenta> cuentas) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.cuentas = cuentas;
    }
    public String getNombreCompleto(){
        return nombre + " " + apellido;
    }
    public boolean esMayorEdad(){
        return edad > 60;
    }
    public double getSaldoTotal(){
        double acc = 0;
        for (Cuenta cuenta: cuentas){
            acc += cuenta.getSaldo();
        }
        return acc;
    }

    public void mostrarCuentas(){
        Cuenta aux;
        ArrayList<Cuenta> cuentasA = cuentas;
        ArrayList<Cuenta> cuentasB = cuentas;
        for (int i = 0; i < cuentasA.size(); i++){
            for (int j = 0; j < cuentasA.size() - 1; j++){
                if (cuentasA.get(j).compareTo(cuentasA.get(j + 1)) == 1){
                    aux = cuentasA.get(j);
                    cuentasA.remove(j);
                    cuentasA.add(j + 1, aux);
                }
            }
        }
        for (Cuenta cuenta: cuentasA){
            System.out.println(cuenta);
            System.out.println("-----------------------------");
        }
        cuentasB.sort(Comparator.comparing(Cuenta::getNroCuenta));
        for (Cuenta cuenta: cuentasB){
            System.out.println(cuenta);
            System.out.println("-----------------------------");
        }
    }
}
