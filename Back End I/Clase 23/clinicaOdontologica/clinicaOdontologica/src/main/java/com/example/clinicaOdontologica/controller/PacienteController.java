package com.example.clinicaOdontologica.controller;

import com.example.clinicaOdontologica.servicios.OdontologoService;
import com.example.clinicaOdontologica.servicios.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@RestController
//@RequestMapping("/index")
@Controller
public class PacienteController {
    private final PacienteService pacienteService = new PacienteService();
    private final OdontologoService odontologoService = new OdontologoService();

    @GetMapping("/index")
    public String welcome(Model model){
        model.addAttribute("nombre", pacienteService.pacientePorMail("emailA").getNombre());
        model.addAttribute("apellido",pacienteService.pacientePorMail("emailA").getApellido());
        model.addAttribute("pacientes", pacienteService.buscarTodos());
        model.addAttribute("matriculaOdontologo",odontologoService.odontologoPorId(1).getMatricula());
        model.addAttribute("matriculasOdontologos", odontologoService.buscarTodos());
        return "index";
    }
}

