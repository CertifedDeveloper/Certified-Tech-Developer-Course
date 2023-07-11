package com.dh.medicamentos.dao;

import java.util.ArrayList;
import java.util.List;

public interface IDao <T>{

    public T guardar(T t);
    public T buscar(Integer id);
    public ArrayList<T> buscarTodos();
}
