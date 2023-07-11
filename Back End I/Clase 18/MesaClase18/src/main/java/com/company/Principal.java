package com.company;

import com.company.DAO.Impl.PacienteDAOH2;
import com.company.Model.Direccion;
import com.company.Model.Paciente;
import com.company.Service.PacienteService;

import java.time.LocalDate;

public class Principal {

    public static void main(String[] args) {
        Direccion domicilio1 = new Direccion("calleA", 123, "localidadA", "provinciaA");
        Paciente paciente1 = new Paciente("Mike","Power","1234", LocalDate.of(2000,1,1), domicilio1);

        PacienteService pepe = new PacienteService(new PacienteDAOH2());


        System.out.println(pepe.guardar(paciente1));
        System.out.println(pepe.leer(1));
        //pepe.eliminar(3);
        //System.out.println(pepe.leer(3));
        //System.out.println(pepe.buscarTodos());


    }
}
