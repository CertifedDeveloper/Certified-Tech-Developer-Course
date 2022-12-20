package com.camada15.clase19;

import java.util.ArrayList;
import java.util.List;

public class Empresa {
    private List<Empleado> empleados;

    public Empresa() {
        empleados = new ArrayList<>();
    }
    public void agregarEmpleado(Empleado empleado){
        empleados.add(empleado);
    }
    public double calcularSueldosTotales(int dias){
        int suma = 0;
        for (Empleado empleado: empleados){
            suma += empleado.calcularSueldo(dias);
        }
        return suma;
    }
}
