package com.company.Service;

import com.company.DAO.IDao;
import com.company.Model.Odontologo;
import com.company.Model.Paciente;

import java.util.ArrayList;

public class OdontologoService {
    private IDao<Odontologo> odontologoDAO;

    public OdontologoService(IDao<Odontologo> odontologoDAO) {
        this.odontologoDAO = odontologoDAO;
    }

    public void setOdontologoDAO(IDao<Odontologo> odontologoDAO) {
        this.odontologoDAO = odontologoDAO;
    }
    public Odontologo leer(int id) {
        return this.odontologoDAO.leer(id);
    }
    public Odontologo guardar(Odontologo odontologo){
        return odontologoDAO.guardar(odontologo);
    }
    public void eliminar(int id){ odontologoDAO.eliminar(id);}
    public ArrayList<Odontologo> buscarTodos(){
        return odontologoDAO.buscarTodos();
    }
}
