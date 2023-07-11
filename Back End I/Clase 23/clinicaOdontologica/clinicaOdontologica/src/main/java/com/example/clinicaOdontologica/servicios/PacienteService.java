package com.example.clinicaOdontologica.servicios;

import com.example.clinicaOdontologica.dominio.Direccion;
import com.example.clinicaOdontologica.dominio.Paciente;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PacienteService {
    Direccion domicilioA = new Direccion("calleA",1234,"localidadA","provinciaA");
    Direccion domicilioB = new Direccion("calleB",1234,"localidadB","provinciaB");
    Paciente pacienteA = new Paciente(1,"nombreA", "apellidoA", "emailA","dniA", LocalDate.of(2000,1,1),domicilioA);
    Paciente pacienteB = new Paciente(1,"nombreB", "apellidoB", "emailB","dniB", LocalDate.of(2000,1,1),domicilioB);
    ArrayList<Paciente> pacientes = new ArrayList<>();
    public List<Paciente> buscarTodos(){
        return Arrays.asList(pacienteA,pacienteB);
    }
    public Paciente pacientePorMail(String email){
        pacientes.add(pacienteA);
        pacientes.add(pacienteB);
        Paciente pacienteEncontrado = null;
        for (Paciente paciente: pacientes){
            if (paciente.getEmail().equalsIgnoreCase(email)){
                pacienteEncontrado = paciente;
            }
        }
        return pacienteEncontrado;
    }
}
