package com.company.Service;

import com.company.DAO.IDao;
import com.company.Model.Turno;

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
}
