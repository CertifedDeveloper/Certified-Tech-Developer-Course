package com.company.Service;

import com.company.DAO.IDao;
import com.company.Model.Paciente;

import java.util.ArrayList;

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
    public Paciente leer(int id) {
        return pacienteDAO.leer(id);
    }

   // @Override
    public Paciente guardar(Paciente elem) {
        return pacienteDAO.guardar(elem);
    }
    public void eliminar(int id){ pacienteDAO.eliminar(id);}
    public ArrayList<Paciente> buscarTodos(){
        return pacienteDAO.buscarTodos();
    }
}
