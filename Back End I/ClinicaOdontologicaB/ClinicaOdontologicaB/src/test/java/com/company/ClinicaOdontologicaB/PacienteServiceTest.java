package com.company.ClinicaOdontologicaB;

import com.company.ClinicaOdontologicaB.dto.PacienteDTO;
import com.company.ClinicaOdontologicaB.exception.ResourceNotFoundException;
import com.company.ClinicaOdontologicaB.model.Direccion;
import com.company.ClinicaOdontologicaB.service.IPacienteService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
@SpringBootTest
class PacienteServiceTest {
    IPacienteService pacienteService;

    @Autowired
    public PacienteServiceTest(IPacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }
    PacienteDTO pacienteDTO;
    Direccion direccion;
    @BeforeEach
    void doBefore(){
        pacienteDTO = new PacienteDTO();
        direccion = new Direccion();
        pacienteDTO.setNombre("NombreA");
        pacienteDTO.setApellido("ApellidoA");
        pacienteDTO.setDni("1234");
        direccion.setCalle("CalleA");
        direccion.setNumero(1234);
        direccion.setLocalidad("LocalidadA");
        direccion.setProvincia("ProvinciaA");
        pacienteDTO.setDomicilio(direccion);
        pacienteDTO.setFecha_ingreso(LocalDate.of(2000,1,1));
    }
    @Test
    void dBuscar() {
        PacienteDTO pacienteDTOB = pacienteService.buscar(1L).orElse(null);
        assertNotNull(pacienteDTOB);
    }

    @Test
    void eRegistrar() {
        pacienteService.registrar(pacienteDTO);

        PacienteDTO pacienteDTOB = pacienteService.buscar(1L).orElse(null);

        assertNotNull(pacienteDTOB);
    }

    @Test
    void aEliminar() throws ResourceNotFoundException {
        pacienteService.eliminar(1L);
        assertNull(pacienteService.buscar(1L).orElse(null));
    }

    @Test
    void bActualizar() throws ResourceNotFoundException {
        pacienteDTO.setNombre("NombreB");
        pacienteDTO.setApellido("ApellidoB");
        pacienteDTO.setFecha_ingreso(LocalDate.of(2001,1,1));
        direccion.setCalle("CalleB");
        direccion.setLocalidad("LocalidadB");
        pacienteDTO.setDomicilio(direccion);

        assertNotNull(pacienteService.actualizar(pacienteDTO));
    }

    @Test
    void cBuscarTodos() {
        assertTrue(pacienteService.buscarTodos().isEmpty());
        assertNotNull(pacienteService.buscarTodos());
    }
}