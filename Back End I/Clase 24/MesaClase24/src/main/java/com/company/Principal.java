package com.company;

import com.company.DAO.Impl.OdontologoDAOH2;
import com.company.DAO.Impl.PacienteDAOH2;
import com.company.DAO.Impl.TurnoDAOH2;
import com.company.Model.Direccion;
import com.company.Model.Odontologo;
import com.company.Model.Paciente;
import com.company.Model.Turno;
import com.company.Service.OdontologoService;
import com.company.Service.PacienteService;
import com.company.Service.TurnoService;

import java.time.LocalDate;

public class Principal {

    public static void main(String[] args) {
        Direccion domicilio1 = new Direccion("calleA", 123, "localidadA", "provinciaA");
        Paciente paciente1 = new Paciente("Mike","Power","1234", LocalDate.of(2000,1,1), domicilio1);
        Odontologo odontologo1 = new Odontologo("AAA","Mike","Power");

        PacienteService pepe = new PacienteService(new PacienteDAOH2());
        OdontologoService odontologoService = new OdontologoService(new OdontologoDAOH2());


        System.out.println(pepe.guardar(paciente1));
        System.out.println(pepe.leer(1));
        System.out.println(odontologoService.guardar(odontologo1));
        System.out.println(odontologoService.leer(1));

        Turno turno = new Turno(pepe.leer(1).getId(), odontologoService.leer(1).getId(), LocalDate.of(2000,1,1));
        TurnoService turnoService = new TurnoService(new TurnoDAOH2());

        System.out.println(turnoService.guardar(turno));

        //pepe.eliminar(3);
        //System.out.println(pepe.leer(3));
        //System.out.println(pepe.buscarTodos());


    }
}
