package com.company.ClinicaOdontologica.repository;

import java.util.ArrayList;
import java.util.Optional;

public interface IDao <T>{

    Optional<T> leer(int id);
    T guardar(T elem);
    void eliminar(int id);
    ArrayList<T> buscarTodos();
    T actualizar(T elem);

}
