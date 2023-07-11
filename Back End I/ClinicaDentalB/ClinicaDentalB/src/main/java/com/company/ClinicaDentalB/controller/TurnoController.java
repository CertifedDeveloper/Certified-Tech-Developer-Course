package com.company.ClinicaDentalB.controller;

import com.company.ClinicaDentalB.dto.TurnoDTO;
import com.company.ClinicaDentalB.exception.BadRequestException;
import com.company.ClinicaDentalB.exception.ResourceNotFoundException;
import com.company.ClinicaDentalB.service.OdontologoService;
import com.company.ClinicaDentalB.service.PacienteService;
import com.company.ClinicaDentalB.service.TurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;

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
    public ResponseEntity<TurnoDTO> registrar(@RequestBody TurnoDTO turnoDTO) throws BadRequestException {
        ResponseEntity<TurnoDTO> response = null;
        response = ResponseEntity.ok(turnoService.registrar(turnoDTO));
        return response;
    }

    @GetMapping
    public ResponseEntity<Collection<TurnoDTO>> buscarTodos(){
        return ResponseEntity.status(HttpStatus.FOUND).body(turnoService.buscarTodos());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable("id") Long id) throws ResourceNotFoundException {
        turnoService.eliminar(id);
        ResponseEntity response = null;
        response = ResponseEntity.status(HttpStatus.NO_CONTENT).body("Turno eliminado");
        return response;
    }
    @PutMapping
    public ResponseEntity<TurnoDTO> actualizar(@RequestBody TurnoDTO turnoDTO) throws BadRequestException, ResourceNotFoundException{
        ResponseEntity<TurnoDTO> response = null;
        response = ResponseEntity.ok(turnoService.actualizar(turnoDTO));
        return response;
     }

     @GetMapping("/{id}")
    public ResponseEntity<TurnoDTO> buscar(@PathVariable("id") Long id){
        TurnoDTO turnoDTO = turnoService.buscar(id).orElse(null);
        return ResponseEntity.status(HttpStatus.FOUND).body(turnoDTO);
     }
}
