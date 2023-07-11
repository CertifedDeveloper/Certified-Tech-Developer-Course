package com.company.ClinicaOdontologica.controller;

import com.company.ClinicaOdontologica.model.Paciente;
import com.company.ClinicaOdontologica.model.Turno;
import com.company.ClinicaOdontologica.repository.Impl.OdontologoDAOH2;
import com.company.ClinicaOdontologica.repository.Impl.PacienteDAOH2;
import com.company.ClinicaOdontologica.service.OdontologoService;
import com.company.ClinicaOdontologica.service.PacienteService;
import com.company.ClinicaOdontologica.service.TurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/turnos")
public class TurnoController {
    TurnoService turnoService;
    PacienteService pacienteService;
    OdontologoService odontologoService;

    @Autowired
    public TurnoController(TurnoService turnoService, PacienteService pacienteService, OdontologoService odontologoService) {
        this.turnoService = turnoService;
        this.pacienteService = pacienteService;
        this.odontologoService = odontologoService;
    }

    @PostMapping
    public ResponseEntity<Turno> guardar(@RequestBody Turno turno){
        ResponseEntity<Turno> response = null;
        if (pacienteService.leer(turno.getPaciente().getId()) != null && odontologoService.leer(turno.getOdontologo().getId()) != null){
            response = ResponseEntity.ok(turnoService.guardar(turno));
        } else {
            response = ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return response;
    }

    @GetMapping
    public ResponseEntity<ArrayList<Turno>> buscarTodos(){
        return ResponseEntity.status(HttpStatus.FOUND).body(turnoService.buscarTodos());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Turno> eliminar(@PathVariable("id") int id){
        ResponseEntity response = null;
        if (turnoService.leer(id) == null){
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } else{
            turnoService.eliminar(id);
            response = ResponseEntity.status(HttpStatus.NO_CONTENT).body("Turno eliminado");
        }
        return response;
    }
    @PutMapping
    public ResponseEntity<Turno> actualizar(@RequestBody Turno turno){
        ResponseEntity<Turno> response = null;
        if (turnoService.leer(turno.getTurnoId()) != null){
            response = ResponseEntity.ok(turnoService.actualizar(turno));
        } else{
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return response;
     }

     @GetMapping("/{id}")
    public ResponseEntity<Turno> leer(@PathVariable("id") int id){
        Turno turno = turnoService.leer(id).orElse(null);
        return ResponseEntity.status(HttpStatus.FOUND).body(turno);
     }
}
