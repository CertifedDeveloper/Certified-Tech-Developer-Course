package com.camada15.clase19;

public class EmpleadoRelacionDependencia extends Empleado{

    private double sueldoMensual;

    public void setSueldoMensual(double sueldoMensual) {
        this.sueldoMensual = sueldoMensual;
    }

    @Override
    public double calcularSueldo(int dias) {
        return (sueldoMensual / 30) * dias;
    }
}
