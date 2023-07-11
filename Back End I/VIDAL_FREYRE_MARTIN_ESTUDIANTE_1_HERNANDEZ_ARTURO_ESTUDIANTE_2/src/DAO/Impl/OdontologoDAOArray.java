package DAO.Impl;

import DAO.IDao;
import Model.Odontologo;

import java.util.ArrayList;

public class OdontologoDAOArray implements IDao<Odontologo> {
    ArrayList<Odontologo> odontologos = new ArrayList<>();
    int nuevoId = 0;
    @Override
    public Odontologo registrar(Odontologo odontologo) {
        nuevoId++;
        odontologo.setId(nuevoId);
        odontologos.add(odontologo);
        return odontologo;
    }

    @Override
    public ArrayList<Odontologo> listarTodos() {
        return odontologos;
    }
}
