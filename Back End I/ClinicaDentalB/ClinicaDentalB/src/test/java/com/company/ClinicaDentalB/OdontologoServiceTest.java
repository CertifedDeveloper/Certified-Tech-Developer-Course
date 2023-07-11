package com.company.ClinicaDentalB;

import com.company.ClinicaDentalB.dto.OdontologoDTO;
import com.company.ClinicaDentalB.service.IOdontologoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class OdontologoServiceTest {
    IOdontologoService odontologoService;

    @Autowired
    public OdontologoServiceTest(IOdontologoService odontologoService) {
        this.odontologoService = odontologoService;
    }

    OdontologoDTO odontologoDTO;

    @BeforeEach
    void doBefore(){
        odontologoDTO = new OdontologoDTO();
        odontologoDTO.setNombre("NombreA");
        odontologoDTO.setApellido("ApellidoA");
        odontologoDTO.setNumeroMatricula("MatriculaA");
    }
    @Test
    void dBuscar() {
        OdontologoDTO odontologoDTOB = odontologoService.buscar(1L).orElse(null);
        assertNotNull(odontologoDTOB);
    }

    @Test
    void eRegistrar() {
        odontologoService.registrar(odontologoDTO);

        OdontologoDTO odontologoDTOB = odontologoService.buscar(1L).orElse(null);

        assertNotNull(odontologoDTOB);
    }

    @Test
    void aEliminar() {
        odontologoService.eliminar(1L);
        assertNull(odontologoService.buscar(1L).orElse(null));
    }

    @Test
    void bActualizar() {
        odontologoDTO.setNombre("NombreB");
        odontologoDTO.setApellido("ApellidoB");
        odontologoDTO.setNumeroMatricula("MatriculaB");

        assertNotNull(odontologoService.actualizar(odontologoDTO));
    }

    @Test
    void cBuscarTodos() {
        assertTrue(odontologoService.buscarTodos().isEmpty());
        assertNotNull(odontologoService.buscarTodos());
    }
}
