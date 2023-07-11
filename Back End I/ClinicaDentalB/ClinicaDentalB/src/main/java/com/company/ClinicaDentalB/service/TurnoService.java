package com.company.ClinicaDentalB.service;

import com.company.ClinicaDentalB.dto.TurnoDTO;
import com.company.ClinicaDentalB.entity.Turno;
import com.company.ClinicaDentalB.exception.BadRequestException;
import com.company.ClinicaDentalB.exception.ResourceNotFoundException;
import com.company.ClinicaDentalB.repository.IOdontologoRepository;
import com.company.ClinicaDentalB.repository.IPacienteRepository;
import com.company.ClinicaDentalB.repository.ITurnoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.geom.NoninvertibleTransformException;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class TurnoService implements ITurnoService{
    private ITurnoRepository turnoRepository;
    private IPacienteService pacienteService;
    private IOdontologoService odontologoService;
    private ObjectMapper objectMapper;

    @Autowired
    public TurnoService(ITurnoRepository turnoRepository, IPacienteService pacienteService, IOdontologoService odontologoService, ObjectMapper objectMapper) {
        this.turnoRepository = turnoRepository;
        this.pacienteService = pacienteService;
        this.odontologoService = odontologoService;
        this.objectMapper = objectMapper;
    }




    @Override
    public Optional<TurnoDTO> buscar(Long id) {
        Optional<Turno> turno = turnoRepository.findById(id);
        TurnoDTO turnoDTO = null;
        if (turno.isPresent()){
            turnoDTO = objectMapper.convertValue(turno, TurnoDTO.class);
        }
        return turnoDTO != null ? Optional.of(turnoDTO):Optional.empty();
    }

    @Override
    public TurnoDTO registrar(TurnoDTO turnoDTO) throws BadRequestException {
        if (pacienteService.buscar(turnoDTO.getPaciente().getId()).isEmpty()){
            throw new BadRequestException("No existe turno con paciente con id: " + turnoDTO.getPaciente().getId());
        }
        if (odontologoService.buscar(turnoDTO.getOdontologo().getId()).isEmpty()){
            throw new BadRequestException("No existe turno con odontologo con id: " + turnoDTO.getOdontologo().getId());
        }
        Turno turno = objectMapper.convertValue(turnoDTO, Turno.class);
        return objectMapper.convertValue(turnoRepository.save(turno), TurnoDTO.class);
    }

    @Override
    public void eliminar(Long id) throws ResourceNotFoundException{
        if(buscar(id).isEmpty()){
            throw new ResourceNotFoundException("No existe turno con id: " + id);
        }
        turnoRepository.deleteById(id);
    }

    @Override
    public TurnoDTO actualizar(TurnoDTO turnoDTO) throws BadRequestException, ResourceNotFoundException {
        if (pacienteService.buscar(turnoDTO.getPaciente().getId()).isEmpty()){
            throw new BadRequestException("No existe turno con paciente con id: " + turnoDTO.getPaciente().getId());
        }
        if (odontologoService.buscar(turnoDTO.getOdontologo().getId()).isEmpty()){
            throw new BadRequestException("No existe turno con odontologo con id: " + turnoDTO.getOdontologo().getId());
        }
        if(buscar(turnoDTO.getTurnoId()).isEmpty()){
            throw new ResourceNotFoundException("No existe turno con id: "+ turnoDTO.getTurnoId());
        }
        Turno turno = objectMapper.convertValue(turnoDTO, Turno.class);
        return objectMapper.convertValue(turnoRepository.save(turno), TurnoDTO.class);
    }

    @Override
    public Set<TurnoDTO> buscarTodos() {
        List<Turno> turnos = turnoRepository.findAll();
        Set<TurnoDTO> turnosDTO = new HashSet<>();
        for(Turno turno:turnos){
            turnosDTO.add(objectMapper.convertValue(turno, TurnoDTO.class));
        }
        return turnosDTO;
    }
}
