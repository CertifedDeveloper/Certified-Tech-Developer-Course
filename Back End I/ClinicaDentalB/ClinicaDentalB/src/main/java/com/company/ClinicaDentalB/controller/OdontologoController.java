package com.company.ClinicaDentalB.controller;

import com.company.ClinicaDentalB.dto.OdontologoDTO;
import com.company.ClinicaDentalB.exception.ResourceNotFoundException;
import com.company.ClinicaDentalB.service.OdontologoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;

@RestController
@RequestMapping("/odontologos")
public class OdontologoController {
    OdontologoService odontologoService;

    @Autowired
    public OdontologoController(OdontologoService odontologoService) {
        this.odontologoService = odontologoService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<OdontologoDTO> buscar(@PathVariable("id") Long id){
        OdontologoDTO odontologoDTO = odontologoService.buscar(id).orElse(null);
        return ResponseEntity.status(HttpStatus.FOUND).body(odontologoDTO);
    }
    @PostMapping
    public ResponseEntity<OdontologoDTO> registrar(@RequestBody OdontologoDTO odontologoDTO){
        return ResponseEntity.ok(odontologoService.registrar(odontologoDTO));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable("id") Long id) throws ResourceNotFoundException {
        odontologoService.eliminar(id);
        ResponseEntity response = null;
        response = ResponseEntity.status(HttpStatus.NO_CONTENT).body("Odontologo eliminado");
        return response;
    }
    @GetMapping
    public ResponseEntity<Collection<OdontologoDTO>> buscarTodos(){
        return ResponseEntity.status(HttpStatus.FOUND).body(odontologoService.buscarTodos());
    }
    @PutMapping
    public ResponseEntity<OdontologoDTO> actualizar(@RequestBody OdontologoDTO odontologoDTO) throws ResourceNotFoundException{
        ResponseEntity response = null;
        response = ResponseEntity.ok(odontologoService.actualizar(odontologoDTO));
        return response;
    }
}
