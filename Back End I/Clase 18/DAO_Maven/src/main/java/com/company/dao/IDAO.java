package com.company.dao;

import java.util.List;

public interface IDAO<T> {
    public T registrar(T t);
    public void eliminar(Long id);
    public T buscar(Long id);
    public List<T> buscarTodos();
}
