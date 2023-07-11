import Desafio.Empleado;
import Desafio.Empresa;

import java.io.*;

public class Main2 {
    public static void main(String[] args) throws IOException {
        Empresa empresa =  new Empresa("CUIT", "empresa");
        Empleado empleadoA = new Empleado("nombreA","apellidoA","legajoA", 1000.);
        Empleado empleadoB = new Empleado("nombreB","apellidoB","legajoB", 500.);
        Empleado empleadoC = new Empleado("nombreC","apellidoC","legajoC", 2000.);
        Empleado empleadoD = new Empleado("nombreD","apellidoD","legajoD", 1000.);
        empresa.getEmpleados().add(empleadoA);
        empresa.getEmpleados().add(empleadoB);
        empresa.getEmpleados().add(empleadoC);
        empresa.getEmpleados().add(empleadoD);

        FileOutputStream fileOutputStream = new FileOutputStream("empleados.txt");
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
        for (Empleado empleado : empresa.getEmpleados()){
            String linea = empleado.getNombre() + ";" + empleado.getApellido() + ";" + empleado.getLegajo() + ";" + empleado.getSueldo() + "\n";
            bufferedOutputStream.write(linea.getBytes());
            System.out.println(linea);
        }
        bufferedOutputStream.close();
        fileOutputStream.close();
    }
}
