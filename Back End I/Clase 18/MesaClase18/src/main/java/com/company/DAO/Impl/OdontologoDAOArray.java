package com.company.DAO.Impl;


import com.company.DAO.IDao;
import com.company.Model.Odontologo;

import java.util.ArrayList;

public class OdontologoDAOArray implements IDao<Odontologo> {
    ArrayList<Odontologo> odontologos = new ArrayList<>();
    int nuevoId = 0;

    @Override
    public Odontologo leer(int id) {
        Odontologo odontologoEncontrado = null;
        for (Odontologo odontologo: odontologos){
            if (odontologo.getId() == id){
                odontologoEncontrado = odontologo;
            }
        }
        return odontologoEncontrado;
    }

    @Override
    public Odontologo guardar(Odontologo odontologo) {
        nuevoId++;
        odontologo.setId(nuevoId);
        odontologos.add(odontologo);
        return odontologo;
    }

    @Override
    public void eliminar(int id) {
        for (Odontologo odontologo: odontologos){
            if (odontologo.getId() == id){
                odontologos.remove(odontologo);
            }
        }
    }

    @Override
    public ArrayList<Odontologo> buscarTodos() {
        return odontologos;
    }
}
