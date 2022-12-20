package com.camada15.clase19;

public class EmpleadoFactory {

    //Singleton
    private static EmpleadoFactory instance;

    private EmpleadoFactory(){
    }

    public static EmpleadoFactory getInstance(){
        if(instance == null){
            instance = new EmpleadoFactory();
        }
        return instance;
    }


    //Factory
    public Empleado construirEmpleado(String tipo){
        switch (tipo){
            case "EMP_RD":
                Empleado emplRD = new EmpleadoRelacionDependencia();
                ((EmpleadoRelacionDependencia)emplRD).setSueldoMensual(1000);
                return emplRD;
            case "EMP_PH":
                EmpleadoContratado empleadoC = new EmpleadoContratado();
                empleadoC.setRetencionImpuesto(0.14);
                empleadoC.setValorHora(7);
                return empleadoC;
            default:
                System.out.println("No se encontro el tipo especificado de empleado");
                return null;
        }
    }
}
