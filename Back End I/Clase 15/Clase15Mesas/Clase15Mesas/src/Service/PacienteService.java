package Service;

import DAO.IDao;
import Model.Paciente;

import java.util.ArrayList;

public class PacienteService {
    public PacienteService(IDao<Paciente> miDao) {
        this.miDao = miDao;
    }

    private IDao<Paciente> miDao;

    public IDao<Paciente> getMiDao() {
        return miDao;
    }

    public void setMiDao(IDao<Paciente> miDao) {
        this.miDao = miDao;
    }

   //@Override
    public Paciente leer(int id) {
        return miDao.leer(id);
    }

   // @Override
    public Paciente guardar(Paciente elem) {
        return miDao.guardar(elem);
    }
    public void eliminar(int id){ miDao.eliminar(id);}
    public ArrayList<Paciente> buscarTodos(){
        return miDao.buscarTodos();
    }
}
