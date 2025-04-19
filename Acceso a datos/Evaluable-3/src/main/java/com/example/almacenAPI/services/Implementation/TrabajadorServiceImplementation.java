package com.example.almacenAPI.services.Implementation;

import com.example.almacenAPI.model.Trabajador;
import com.example.almacenAPI.repository.TrabajadorRepository;
import com.example.almacenAPI.services.TrabajadorService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TrabajadorServiceImplementation implements TrabajadorService {

    @Autowired
    private TrabajadorRepository trabajadorRepository;

    @Override
    public List<Trabajador> findAll() {
        return trabajadorRepository.findAll();
    }

    @Override
    public Optional<Trabajador> findById(Integer id) {
        return trabajadorRepository.findById(id);
    }

    @Override
    public List<Trabajador> findByEdadGreaterThan(int edad) {
        return trabajadorRepository.findByEdadGreaterThan(edad);
    }

    @Override
    public List<Trabajador> findByEdadLessThan(int edad) {
        return trabajadorRepository.findByEdadLessThan(edad);
    }

    @Override
    public List<Trabajador> findByNacionalidad(String nacionalidad) {
        return trabajadorRepository.findByNacionalidad(nacionalidad);
    }

    @Override
    public Integer countByEdadGreaterThan(int edad) {
        return trabajadorRepository.countByEdadGreaterThan(edad);
    }

    @Override
    public Integer countByEdadLessThan(int edad) {
        return trabajadorRepository.countByEdadLessThan(edad);
    }

    @Override
    public Trabajador save(Trabajador trabajador) {
        return trabajadorRepository.save(trabajador);
    }

    @Override
    public void deleteById(Integer id) {
        if(!trabajadorRepository.existsById(id)){
            throw new EntityNotFoundException("Trabajador no encontrado con la id: "+ id);
        }
        trabajadorRepository.deleteById(id);
    }

}
