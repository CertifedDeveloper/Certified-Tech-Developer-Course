package com.company.ClinicaOdontologica.service;

import com.company.ClinicaOdontologica.repository.IDao;
import com.company.ClinicaOdontologica.model.Odontologo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class OdontologoService {
    private IDao<Odontologo> odontologoDAO;

    public OdontologoService(IDao<Odontologo> odontologoDAO) {
        this.odontologoDAO = odontologoDAO;
    }

    public void setOdontologoDAO(IDao<Odontologo> odontologoDAO) {
        this.odontologoDAO = odontologoDAO;
    }
    public Optional<Odontologo> leer(int id) {
        return this.odontologoDAO.leer(id);
    }
    public Odontologo guardar(Odontologo odontologo){
        return odontologoDAO.guardar(odontologo);
    }
    public void eliminar(int id){ odontologoDAO.eliminar(id);}
    public ArrayList<Odontologo> buscarTodos(){
        return odontologoDAO.buscarTodos();
    }
    public Odontologo actualizar(Odontologo odontologo){ return odontologoDAO.actualizar(odontologo);};
}
