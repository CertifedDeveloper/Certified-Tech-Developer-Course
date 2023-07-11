package com.company.ClinicaOdontologica.repository.Impl;

import com.company.ClinicaOdontologica.repository.IDao;
import com.company.ClinicaOdontologica.model.Odontologo;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Optional;

@Repository
public class OdontologoDAOArray implements IDao<Odontologo> {
    ArrayList<Odontologo> odontologos = new ArrayList<>();
    int nuevoId = 0;

    @Override
    public Optional<Odontologo> leer(int id) {
        Odontologo odontologoEncontrado = null;
        for (Odontologo odontologo: odontologos){
            if (odontologo.getId() == id){
                odontologoEncontrado = odontologo;
            }
        }
        return odontologoEncontrado != null ? Optional.of(odontologoEncontrado) : Optional.empty();
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

    @Override
    public Odontologo actualizar(Odontologo elem) {
        return null;
    }
}
