package Service;

import DAO.IDao;
import Model.Odontologo;

import java.util.ArrayList;

public class OdontologoService {
    private IDao<Odontologo> odontologoDAO;

    public OdontologoService(IDao<Odontologo> odontologoDAO) {
        this.odontologoDAO = odontologoDAO;
    }

    public void setOdontologoDAO(IDao<Odontologo> odontologoDAO) {
        this.odontologoDAO = odontologoDAO;
    }
    public Odontologo registrar(Odontologo odontologo){
        return odontologoDAO.registrar(odontologo);
    }
    public ArrayList<Odontologo> listarTodos(){
        return odontologoDAO.listarTodos();
    }
}
