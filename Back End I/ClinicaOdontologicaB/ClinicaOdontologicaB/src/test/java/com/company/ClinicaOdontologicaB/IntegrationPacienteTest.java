package com.company.ClinicaOdontologicaB;

import com.company.ClinicaOdontologicaB.dto.PacienteDTO;
import com.company.ClinicaOdontologicaB.model.Direccion;
import com.company.ClinicaOdontologicaB.model.Paciente;
import com.company.ClinicaOdontologicaB.service.PacienteService;
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
public class IntegrationPacienteTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private PacienteService pacienteService;


    public void cargarDataSet() {
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
        pacienteService.registrar(paciente);
    }
    @Test
    public void listarPacientes() throws Exception {
        this.cargarDataSet();
        MvcResult response = mockMvc.perform(MockMvcRequestBuilders.get("/pacientes/{id}", 1).accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk()).andReturn();

        Assert.assertFalse(response.getResponse().getContentAsString().isEmpty());
    }
}
