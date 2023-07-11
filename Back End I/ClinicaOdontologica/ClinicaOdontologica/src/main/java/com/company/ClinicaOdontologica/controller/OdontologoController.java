package com.company.ClinicaOdontologica.controller;

import com.company.ClinicaOdontologica.model.Odontologo;
import com.company.ClinicaOdontologica.service.OdontologoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/odontologos")
public class OdontologoController {
    OdontologoService odontologoService;

    @Autowired
    public OdontologoController(OdontologoService odontologoService) {
        this.odontologoService = odontologoService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Odontologo> leer(@PathVariable("id") int id){
        Odontologo odontologo = odontologoService.leer(id).orElse(null);
        return ResponseEntity.status(HttpStatus.FOUND).body(odontologo);
    }
    @PostMapping
    public ResponseEntity<Odontologo> guardar(@RequestBody Odontologo odontologo){
        return ResponseEntity.ok(odontologoService.guardar(odontologo));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Odontologo> eliminar(@PathVariable("id") int id){
        ResponseEntity response = null;
        if (odontologoService.leer(id) == null){
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } else {
            odontologoService.eliminar(id);
            response = ResponseEntity.status(HttpStatus.NO_CONTENT).body("Odontologo eliminado");
        }
        return response;
    }
    @GetMapping
    public ResponseEntity<ArrayList<Odontologo>> buscarTodos(){
        return ResponseEntity.status(HttpStatus.FOUND).body(odontologoService.buscarTodos());
    }
    @PutMapping
    public ResponseEntity<Odontologo> actualizar(@RequestBody Odontologo odontologo){
        ResponseEntity response = null;
        if (odontologoService.leer(odontologo.getId()) == null){
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } else {
            odontologoService.actualizar(odontologo);
            response = ResponseEntity.ok(odontologoService.actualizar(odontologo));
        }
        return response;
    }
}
