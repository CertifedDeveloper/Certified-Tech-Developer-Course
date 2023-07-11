package com.company.ClinicaDentalB.dto;

import com.company.ClinicaDentalB.entity.Odontologo;
import com.company.ClinicaDentalB.entity.Paciente;

import java.time.LocalDate;

public class TurnoDTO {
    private Long turnoId;
    private Paciente paciente;
    private Odontologo odontologo;
    private LocalDate fechaHora;
    public Long getTurnoId() {
        return turnoId;
    }

    public void setTurnoId(Long turnoId) {
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
