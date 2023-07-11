package com.company;

import com.company.DAO.Impl.OdontologoDAOH2;
import com.company.DAO.Impl.PacienteDAOH2;
import com.company.Model.Direccion;
import com.company.Model.Odontologo;
import com.company.Model.Paciente;
import com.company.Service.OdontologoService;
import com.company.Service.PacienteService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PacienteServiceTest {
    Paciente paciente1;
    Paciente paciente2;
    Paciente paciente3;
    Paciente paciente4;
    Direccion domicilio1;
    Direccion domicilio2;
    Direccion domicilio3;
    Direccion domicilio4;
    PacienteService pacienteService;
    ArrayList<Paciente> pacientes = new ArrayList<>();
    @BeforeEach
    void doBefore(){
        domicilio1 = new Direccion("calleA", 123, "localidadA", "provinciaA");
        domicilio2 = new Direccion("calleB", 123, "localidadB", "provinciaB");
        domicilio3 = new Direccion("calleC", 123, "localidadC", "provinciaC");
        domicilio4 = new Direccion("calleD", 123, "localidadD", "provinciaD");
        paciente1 = new Paciente("Mike","Power","1234", LocalDate.of(2000,1,1), domicilio1);
        paciente2 = new Paciente("Jack","Sparrow","1234", LocalDate.of(2000,1,1), domicilio2);
        paciente3 = new Paciente("Peter","Parker","1234", LocalDate.of(2000,1,1), domicilio3);
        paciente4 = new Paciente("MikeB","PowerB","1234", LocalDate.of(2000,1,1), domicilio4);
        pacienteService = new PacienteService(new PacienteDAOH2());
    }

    @Test
    void guardar() {
        Direccion domicilioA = new Direccion("calleA", 123, "localidadA", "provinciaA");
        domicilioA.setId(1);
        Paciente pacienteA = new Paciente("Mike","Power","1234", LocalDate.of(2000,1,1), domicilioA);
        pacienteA.setId(1);

        assertEquals(pacienteA.toString(), pacienteService.guardar(paciente1).toString());
    }
    @Test
    void buscarTodos() {
        Direccion domicilioA = new Direccion("calleA", 123, "localidadA", "provinciaA");
        Direccion domicilioB = new Direccion("calleB", 123, "localidadB", "provinciaB");
        Direccion domicilioC = new Direccion("calleC", 123, "localidadC", "provinciaC");
        Direccion domicilioD = new Direccion("calleD", 123, "localidadD", "provinciaD");
        domicilioA.setId(1);
        domicilioB.setId(2);
        domicilioC.setId(3);
        domicilioD.setId(4);
        Paciente pacienteA = new Paciente("Mike","Power","1234", LocalDate.of(2000,1,1), domicilioA);
        Paciente pacienteB = new Paciente("Jack","Sparrow","1234", LocalDate.of(2000,1,1), domicilioB);
        Paciente pacienteC = new Paciente("Peter","Parker","1234", LocalDate.of(2000,1,1), domicilioC);
        Paciente pacienteD = new Paciente("MikeB","PowerB","1234", LocalDate.of(2000,1,1), domicilioD);
        pacienteA.setId(1);
        pacienteB.setId(2);
        pacienteC.setId(3);
        pacienteD.setId(4);
        pacientes.add(pacienteA);
        pacientes.add(pacienteB);
        pacientes.add(pacienteC);
        pacientes.add(pacienteD);

        pacienteService.guardar(paciente2);
        pacienteService.guardar(paciente3);
        pacienteService.guardar(paciente4);

        assertEquals(pacientes.toString(), pacienteService.buscarTodos().toString());
    }
}