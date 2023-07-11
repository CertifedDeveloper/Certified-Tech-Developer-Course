package com.company.ClinicaOdontologicaB;

import com.company.ClinicaOdontologicaB.dto.OdontologoDTO;
import com.company.ClinicaOdontologicaB.dto.PacienteDTO;
import com.company.ClinicaOdontologicaB.dto.TurnoDTO;
import com.company.ClinicaOdontologicaB.exception.BadRequestException;
import com.company.ClinicaOdontologicaB.model.Direccion;
import com.company.ClinicaOdontologicaB.model.Odontologo;
import com.company.ClinicaOdontologicaB.model.Paciente;
import com.company.ClinicaOdontologicaB.model.Turno;
import com.company.ClinicaOdontologicaB.service.OdontologoService;
import com.company.ClinicaOdontologicaB.service.PacienteService;
import com.company.ClinicaOdontologicaB.service.TurnoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDate;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc(addFilters = false)
public class IntegracionTurnosTest {
    @Autowired
    private PacienteService pacienteService;
    @Autowired
    private OdontologoService odontologoService;
    @Autowired
    private TurnoService turnoService;
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    public void cargarDataSet() throws BadRequestException {
        Direccion domicilio = null;
        domicilio.setCalle("Av Santa fe");
        domicilio.setNumero(444);
        domicilio.setLocalidad("CABA");
        domicilio.setProvincia("Buenos Aires");
        PacienteDTO paciente = null;
        paciente.setNombre("Santiago");
        paciente.setApellido("Paz");
        paciente.setDni("88888888");
        paciente.setFecha_ingreso(LocalDate.of(2000,1,1));
        paciente.setDomicilio(domicilio);
        OdontologoDTO odontologo = null;
        odontologo.setNombre("Santiago");
        odontologo.setApellido("Paz");
        odontologo.setNumeroMatricula("3455647");
        pacienteService.registrar(paciente);
        odontologoService.registrar(odontologo);
        TurnoDTO turno = null;
        turno.setPaciente(objectMapper.convertValue(pacienteService.buscar(1L).orElse(null), Paciente.class));
        turno.setOdontologo(objectMapper.convertValue(odontologoService.buscar(1L).orElse(null), Odontologo.class));
        turno.setFechaHora(LocalDate.of(2000,1,1));
        turnoService.registrar(turno);

    }
    @Test
    public void listarTurnos() throws Exception {
        this.cargarDataSet();
        MvcResult response = mockMvc.perform(MockMvcRequestBuilders.get("/turnos").accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk()).andReturn();

        Assert.assertFalse(response.getResponse().getContentAsString().isEmpty());
    }
}
