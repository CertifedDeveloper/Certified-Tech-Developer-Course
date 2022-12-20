package com.camada15.clase19;

public class Main {
    public static void main(String[] args) {

        Empleado empleado1 = EmpleadoFactory.getInstance().construirEmpleado("EMP_RD");
        Empleado empleado2 = EmpleadoFactory.getInstance().construirEmpleado("EMP_PH");

        empleado1.setNombre("Lu");
        System.out.println(empleado1.calcularSueldo(8));
        empleado2.setNombre("Nombre");
        System.out.println(empleado2.calcularSueldo(8));
        Empresa empresa = new Empresa();
        empresa.agregarEmpleado(empleado1);
        empresa.agregarEmpleado(empleado2);
        System.out.println(empresa.calcularSueldosTotales(8));

    }
}
