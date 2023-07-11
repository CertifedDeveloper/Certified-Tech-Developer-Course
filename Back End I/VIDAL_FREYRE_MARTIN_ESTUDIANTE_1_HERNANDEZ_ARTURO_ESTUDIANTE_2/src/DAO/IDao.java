package DAO;

import java.util.ArrayList;

public interface IDao <T>{

    T registrar(T elem);
    ArrayList<T> listarTodos();

}
