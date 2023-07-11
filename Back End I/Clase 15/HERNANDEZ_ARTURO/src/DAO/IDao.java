package DAO;

import java.util.ArrayList;

public interface IDao <T>{

    T leer(int id);
    T guardar(T elem);
    void eliminar(int id);
    ArrayList<T> buscarTodos();

}
