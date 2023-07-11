package com.company.ClinicaOdontologicaB;

import com.company.ClinicaOdontologicaB.dto.OdontologoDTO;
import com.company.ClinicaOdontologicaB.dto.PacienteDTO;
import com.company.ClinicaOdontologicaB.dto.TurnoDTO;
import com.company.ClinicaOdontologicaB.exception.BadRequestException;
import com.company.ClinicaOdontologicaB.exception.ResourceNotFoundException;
import com.company.ClinicaOdontologicaB.model.Direccion;
import com.company.ClinicaOdontologicaB.model.Odontologo;
import com.company.ClinicaOdontologicaB.model.Paciente;
import com.company.ClinicaOdontologicaB.service.IOdontologoService;
import com.company.ClinicaOdontologicaB.service.IPacienteService;
import com.company.ClinicaOdontologicaB.service.ITurnoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest
public class TurnoServiceTest {
    ITurnoService turnoService;
    IPacienteService pacienteService;
    IOdontologoService odontologoService;
    private ObjectMapper objectMapper;

    @Autowired
    public TurnoServiceTest(ITurnoService turnoService, IPacienteService pacienteService, IOdontologoService odontologoService, ObjectMapper objectMapper) {
        this.turnoService = turnoService;
        this.pacienteService = pacienteService;
        this.odontologoService = odontologoService;
        this.objectMapper = objectMapper;
    }

    Paciente paciente;
    Direccion direccion;
    Odontologo odontologo;
    TurnoDTO turnoDTO;
    @BeforeEach
    void doBefore(){
        paciente = new Paciente();
        direccion = new Direccion();
        paciente.setNombre("NombreA");
        paciente.setApellido("ApellidoA");
        paciente.setDni("1234");
        direccion.setCalle("CalleA");
        direccion.setNumero(1234);
        direccion.setLocalidad("LocalidadA");
        direccion.setProvincia("ProvinciaA");
        paciente.setDomicilio(direccion);
        paciente.setFecha_ingreso(LocalDate.of(2000,1,1));

        odontologo = new Odontologo();
        odontologo.setNombre("NombreA");
        odontologo.setApellido("ApellidoA");
        odontologo.setNumeroMatricula("MatriculaA");

        turnoDTO = new TurnoDTO();
        turnoDTO.setPaciente(paciente);
        turnoDTO.setOdontologo(odontologo);
        turnoDTO.setFechaHora(LocalDate.of(2000,1,1));

    }
    @Test
    void dBuscar() {
        TurnoDTO turnoDTO = turnoService.buscar(1L).orElse(null);
        assertNotNull(turnoDTO);
    }

    @Test
    void eRegistrar() throws BadRequestException {
        OdontologoDTO odontologoRegistrado = odontologoService.registrar(objectMapper.convertValue(odontologo, OdontologoDTO.class));
        PacienteDTO pacienteRegistrado = pacienteService.registrar(objectMapper.convertValue(paciente, PacienteDTO.class));
        Long paciente_id = pacienteRegistrado.getId();
        Long odontolog_id = odontologoRegistrado.getId();
        paciente.setId(paciente_id);
        odontologo.setId(odontolog_id);
        turnoDTO.setPaciente(paciente);
        turnoDTO.setOdontologo(odontologo);

        if (pacienteService.buscar(turnoDTO.getPaciente().getId()).isPresent() && odontologoService.buscar(turnoDTO.getOdontologo().getId()).isPresent()){
            turnoService.registrar(turnoDTO);
            TurnoDTO turnoDTOB = turnoService.buscar(1L).orElse(null);
            assertNotNull(turnoDTOB);
        }


    }

    @Test
    void aEliminar() throws ResourceNotFoundException {
        turnoService.eliminar(1L);
        assertNull(turnoService.buscar(1L).orElse(null));
    }

    @Test
    void bActualizar() throws BadRequestException, ResourceNotFoundException {
        paciente.setNombre("NombreB");
        paciente.setApellido("ApellidoB");
        paciente.setFecha_ingreso(LocalDate.of(2001,1,1));
        direccion.setCalle("CalleB");
        direccion.setLocalidad("LocalidadB");
        paciente.setDomicilio(direccion);
        odontologo.setNombre("NombreB");
        odontologo.setApellido("ApellidoB");
        odontologo.setNumeroMatricula("MatriculaB");

        turnoDTO.setFechaHora(LocalDate.of(2001,1,1));

        OdontologoDTO odontologoRegistrado = odontologoService.registrar(objectMapper.convertValue(odontologo, OdontologoDTO.class));
        PacienteDTO pacienteRegistrado = pacienteService.registrar(objectMapper.convertValue(paciente, PacienteDTO.class));
        Long paciente_id = pacienteRegistrado.getId();
        Long odontolog_id = odontologoRegistrado.getId();
        paciente.setId(paciente_id);
        odontologo.setId(odontolog_id);
        turnoDTO.setPaciente(paciente);
        turnoDTO.setOdontologo(odontologo);

        if (pacienteService.buscar(turnoDTO.getPaciente().getId()).isPresent() && odontologoService.buscar(turnoDTO.getOdontologo().getId()).isPresent()){
            assertNotNull(turnoService.actualizar(turnoDTO));
        }
    }

    @Test
    void cBuscarTodos() {
        assertTrue(turnoService.buscarTodos().isEmpty());
        assertNotNull(turnoService.buscarTodos());
    }
}
