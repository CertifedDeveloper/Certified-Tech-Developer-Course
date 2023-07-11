package com.company.ClinicaOdontologica.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;
import java.util.Optional;

public class Turno {
    private int turnoId;
    private Paciente paciente;
    private Odontologo odontologo;
    private LocalDate fechaHora;

    public Turno() {
    }

    public Turno(Paciente paciente, Odontologo odontologo, LocalDate fechaHora) {
        this.paciente = paciente;
        this.odontologo = odontologo;
        this.fechaHora = fechaHora;
    }

    public Turno(int turnoId, Paciente paciente, Odontologo odontologo, LocalDate fechaHora) {
        this.turnoId = turnoId;
        this.paciente = paciente;
        this.odontologo = odontologo;
        this.fechaHora = fechaHora;
    }

    public int getTurnoId() {
        return turnoId;
    }

    public void setTurnoId(int turnoId) {
        this.turnoId = turnoId;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Odontologo getOdontologo() {
        return odontologo;
    }

    public void setOdontologo(Odontologo odontologo) {
        this.odontologo = odontologo;
    }

    public LocalDate getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDate fechaHora) {
        this.fechaHora = fechaHora;
    }
}
