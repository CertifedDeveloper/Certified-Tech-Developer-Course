package com.company.ClinicaDentalB.service;

import com.company.ClinicaDentalB.dto.OdontologoDTO;
import com.company.ClinicaDentalB.entity.Odontologo;
import com.company.ClinicaDentalB.exception.ResourceNotFoundException;
import com.company.ClinicaDentalB.repository.IOdontologoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class OdontologoService implements IOdontologoService{
    private IOdontologoRepository odontologoRepository;
    private ObjectMapper objectMapper;

    @Autowired
    public OdontologoService(IOdontologoRepository odontologoRepository, ObjectMapper objectMapper) {
        this.odontologoRepository = odontologoRepository;
        this.objectMapper = objectMapper;
    }

    @Override
    public Optional<OdontologoDTO> buscar(Long id) {
        Optional<Odontologo> odontologo = odontologoRepository.findById(id);
        OdontologoDTO odontologoDTO = null;
        if (odontologo.isPresent()){
            odontologoDTO = objectMapper.convertValue(odontologo, OdontologoDTO.class);
        }
        return odontologoDTO != null ? Optional.of(odontologoDTO):Optional.empty();
    }

    @Override
    public OdontologoDTO registrar(OdontologoDTO odontologoDTO) {
        Odontologo odontologo = objectMapper.convertValue(odontologoDTO, Odontologo.class);
        return objectMapper.convertValue(odontologoRepository.save(odontologo), OdontologoDTO.class);
    }

    @Override
    public void eliminar(Long id) throws ResourceNotFoundException{
        if(buscar(id).isEmpty()){
            throw new ResourceNotFoundException("No existe odontolgo con id: " + id);
        }
        odontologoRepository.deleteById(id);
    }

    @Override
    public OdontologoDTO actualizar(OdontologoDTO odontologoDTO) throws ResourceNotFoundException{
        if (buscar(odontologoDTO.getId()).isEmpty()){
            throw new ResourceNotFoundException("No existe odontologo con id: " + odontologoDTO.getId());
        }
        Odontologo odontologo = objectMapper.convertValue(odontologoDTO, Odontologo.class);
        return objectMapper.convertValue(odontologoRepository.save(odontologo), OdontologoDTO.class);
    }

    @Override
    public Set<OdontologoDTO> buscarTodos() {
        List<Odontologo> odontologos = odontologoRepository.findAll();
        Set<OdontologoDTO> odontologosDTO = new HashSet<>();
        for(Odontologo odontologo:odontologos){
            odontologosDTO.add(objectMapper.convertValue(odontologo, OdontologoDTO.class));
        }
        return odontologosDTO;
    }
}
