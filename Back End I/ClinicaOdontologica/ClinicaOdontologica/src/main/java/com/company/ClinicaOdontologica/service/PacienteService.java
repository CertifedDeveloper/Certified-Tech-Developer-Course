package com.company.ClinicaOdontologica.service;

import com.company.ClinicaOdontologica.repository.IDao;
import com.company.ClinicaOdontologica.model.Paciente;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class PacienteService {
    public PacienteService(IDao<Paciente> pacienteDAO) {
        this.pacienteDAO = pacienteDAO;
    }

    private IDao<Paciente> pacienteDAO;

    public IDao<Paciente> getMiDao() {
        return pacienteDAO;
    }

    public void setMiDao(IDao<Paciente> miDao) {
        this.pacienteDAO = pacienteDAO;
    }

   //@Override
    public Optional<Paciente> leer(int id) {
        return pacienteDAO.leer(id);
    }

   // @Override
    public Paciente guardar(Paciente paciente) {
        return pacienteDAO.guardar(paciente);
    }
    public void eliminar(int id){ pacienteDAO.eliminar(id);}
    public ArrayList<Paciente> buscarTodos(){
        return pacienteDAO.buscarTodos();
    }
    public Paciente actualizar(Paciente paciente){return pacienteDAO.actualizar(paciente);}
}
