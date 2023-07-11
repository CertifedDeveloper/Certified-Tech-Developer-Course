package com.company.ClinicaDentalB;

import com.company.ClinicaDentalB.dto.PacienteDTO;
import com.company.ClinicaDentalB.entity.Direccion;
import com.company.ClinicaDentalB.service.IPacienteService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
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
    void aEliminar() {
        pacienteService.eliminar(1L);
        assertNull(pacienteService.buscar(1L).orElse(null));
    }

    @Test
    void bActualizar() {
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