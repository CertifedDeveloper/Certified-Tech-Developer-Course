package com.company.ClinicaDentalB.service;

import com.company.ClinicaDentalB.dto.OdontologoDTO;
import com.company.ClinicaDentalB.dto.PacienteDTO;
import com.company.ClinicaDentalB.exception.ResourceNotFoundException;

import java.util.Optional;
import java.util.Set;

public interface IOdontologoService {
    public Optional<OdontologoDTO> buscar(Long id);
    public OdontologoDTO registrar(OdontologoDTO odontologoDTO);
    public void eliminar(Long id) throws ResourceNotFoundException;
    public OdontologoDTO actualizar(OdontologoDTO odontologoDTO) throws ResourceNotFoundException;
    public Set<OdontologoDTO> buscarTodos();
}
