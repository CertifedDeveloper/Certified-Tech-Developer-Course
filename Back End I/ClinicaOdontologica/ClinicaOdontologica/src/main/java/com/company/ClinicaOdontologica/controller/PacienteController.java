package com.company.ClinicaOdontologica.controller;

import com.company.ClinicaOdontologica.model.Paciente;
import com.company.ClinicaOdontologica.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {
    PacienteService pacienteService;
    @Autowired
    public PacienteController(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }
    @GetMapping("/{id}")
    public ResponseEntity<Paciente> leer(@PathVariable("id") int id){
        Paciente paciente = pacienteService.leer(id).orElse(null);
        return ResponseEntity.status(HttpStatus.FOUND).body(paciente);
    }
    @PostMapping
    public ResponseEntity<Paciente> guardar(@RequestBody Paciente paciente){
        return ResponseEntity.ok(pacienteService.guardar(paciente));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Paciente> eliminar(@PathVariable("id") int id){
        ResponseEntity response = null;
        if (pacienteService.leer(id) == null){
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } else {
            pacienteService.eliminar(id);
            response = ResponseEntity.status(HttpStatus.NO_CONTENT).body("Paciente eliminado");
        }
        return response;
    }
    @GetMapping
    public ResponseEntity<ArrayList<Paciente>> buscarTodos(){
        return ResponseEntity.status(HttpStatus.FOUND).body(pacienteService.buscarTodos());
    }
    @PutMapping()
    public ResponseEntity<Paciente> actualizar(@RequestBody Paciente paciente) {
        ResponseEntity<Paciente> response = null;
        if (pacienteService.leer(paciente.getId()) != null)
            response = ResponseEntity.ok(pacienteService.actualizar(paciente));
        else
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        return response;
    }
}
