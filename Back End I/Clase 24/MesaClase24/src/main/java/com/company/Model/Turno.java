package com.company.Model;

import java.time.LocalDate;

public class Turno {
    private int turnoId;
    private int pacienteId;
    private int odontologoId;
    private LocalDate fechaHora;

    public Turno(int pacienteId, int odontologoId, LocalDate fechaHora) {
        this.pacienteId = pacienteId;
        this.odontologoId = odontologoId;
        this.fechaHora = fechaHora;
    }

    public Turno(int turnoId, int pacienteId, int odontologoId, LocalDate fechaHora) {
        this.turnoId = turnoId;
        this.pacienteId = pacienteId;
        this.odontologoId = odontologoId;
        this.fechaHora = fechaHora;
    }

    public int getTurnoId() {
        return turnoId;
    }

    public void setTurnoId(int turnoId) {
        this.turnoId = turnoId;
    }

    public int getPacienteId() {
        return pacienteId;
    }

    public void setPacienteId(int pacienteId) {
        this.pacienteId = pacienteId;
    }

    public int getOdontologoId() {
        return odontologoId;
    }

    public void setOdontologoId(int odontologoId) {
        this.odontologoId = odontologoId;
    }

    public LocalDate getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDate fechaHora) {
        this.fechaHora = fechaHora;
    }

    @Override
    public String toString() {
        return "Turno{" +
                "turnoId=" + turnoId +
                ", pacienteId=" + pacienteId +
                ", odontologoId=" + odontologoId +
                ", fechaHora=" + fechaHora +
                '}';
    }
}
