import Desafio.Empleado;
import Desafio.Empresa;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Empresa empresa = new Empresa("CUIT","empresa");
        Empleado empleadoA = new Empleado("nombreA","apellidoA","legajoA", 1000.);
        Empleado empleadoB = new Empleado("nombreB","apellidoB","legajoB", 500.);
        Empleado empleadoC = new Empleado("nombreC","apellidoC","legajoC", 2000.);
        Empleado empleadoD = new Empleado("nombreD","apellidoD","legajoD", 1000.);
        empresa.getEmpleados().add(empleadoA);
        empresa.getEmpleados().add(empleadoB);
        empresa.getEmpleados().add(empleadoC);
        empresa.getEmpleados().add(empleadoD);

        FileOutputStream fileOutputStream = new FileOutputStream("OutputFile.txt");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(empresa);

        FileInputStream fileInputStream = new FileInputStream("OutputFile.txt");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

        System.out.println(objectInputStream.readObject());
        objectInputStream.close();
        fileInputStream.close();
        objectOutputStream.close();
        fileOutputStream.close();
    }
}