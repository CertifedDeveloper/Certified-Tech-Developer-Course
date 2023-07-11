package Desafio;

import java.io.Serializable;
import java.util.ArrayList;

public class Empresa implements Serializable {
    private String CIUT;
    private String razonSocial;
    private ArrayList<Empleado> empleados;

    public Empresa(String CIUT, String razonSocial) {
        this.CIUT = CIUT;
        this.razonSocial = razonSocial;
        this.empleados = new ArrayList<>();
    }

    public ArrayList<Empleado> getEmpleados() {
        return empleados;
    }


    @Override
    public String toString() {
        return "Empresa{" +
                "CIUT='" + CIUT + '\'' +
                ", razonSocial='" + razonSocial + '\'' +
                ", empleados=" + empleados +
                '}';
    }
}
