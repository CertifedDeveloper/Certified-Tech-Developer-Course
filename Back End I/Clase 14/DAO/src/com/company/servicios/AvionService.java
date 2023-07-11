package com.company.servicios;

import com.company.dao.IDAO;
import com.company.entidades.Avion;

import java.util.List;

public class AvionService {
    private IDAO<Avion> avionIDAO;

    public IDAO<Avion> getAvionIDAO() {
        return avionIDAO;
    }

    public void setAvionIDAO(IDAO<Avion> avionIDAO) {
        this.avionIDAO = avionIDAO;
    }
    public Avion registrar(Avion avion){
        return avionIDAO.registrar(avion);
    }
    public void eliminar(Long id){
        avionIDAO.eliminar(id);
    }
    public Avion buscar(Long id){
        return avionIDAO.buscar(id);
    }
    public List<Avion> buscarTodos(){
        return avionIDAO.buscarTodos();
    }
}
