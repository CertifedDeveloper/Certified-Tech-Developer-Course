package com.camada15.clase19;

public class EmpleadoContratado extends Empleado{

    private double valorHora;
    private double retencionImpuesto;


    public void setValorHora(double valorHora) {
        this.valorHora = valorHora;
    }

    public void setRetencionImpuesto(double retencionImpuesto) {
        this.retencionImpuesto = retencionImpuesto;
    }

    @Override
    public double calcularSueldo(int dias) {
        double sueldoBruto = valorHora * 8 * dias;
        return sueldoBruto - (sueldoBruto * retencionImpuesto);
    }
}
