package com.company.ClinicaOdontologica.service;

import com.company.ClinicaOdontologica.repository.IDao;
import com.company.ClinicaOdontologica.model.Turno;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class TurnoService {
    private IDao<Turno> turnoIDao;

    public TurnoService(IDao<Turno> turnoIDao) {
        this.turnoIDao = turnoIDao;
    }

    public void setTurnoIDao(IDao<Turno> turnoIDao) {
        this.turnoIDao = turnoIDao;
    }
    public Turno guardar(Turno turno){
        return turnoIDao.guardar(turno);
    }
    public ArrayList<Turno> buscarTodos(){ return turnoIDao.buscarTodos();}
    public Optional<Turno> leer(int id){ return turnoIDao.leer(id);}
    public void eliminar(int id){ turnoIDao.eliminar(id);}
    public Turno actualizar(Turno turno){ return turnoIDao.actualizar(turno);}
}
