package com.example.odontologo.service;

import com.example.odontologo.domain.Odontologo;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

public interface OdontologoService {
    List<Odontologo> listaOdontologos();
}