package com.example.almacenAPI.services.Implementation;

import com.example.almacenAPI.model.Produccion;
import com.example.almacenAPI.repository.ProduccionRepository;
import com.example.almacenAPI.services.ProduccionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProduccionServiceImplementation implements ProduccionService {

    @Autowired
    private ProduccionRepository produccionRepository;

    @Override
    public List<Produccion> findAll() {
        return produccionRepository.findAll();
    }

    @Override
    public Produccion save(Produccion produccion) {
        return produccionRepository.save(produccion);
    }

    @Override
    public void deleteById(Long id) {
        produccionRepository.deleteById(id);
    }

    @Override
    public List<Produccion> findByTrabajadorId(Integer trabajadorId) {
        return produccionRepository.findByTrabajadorId(trabajadorId);
    }

    @Override
    public List<Produccion> findByAlmacenId(Integer almacenId) {
        return produccionRepository.findByAlmacenId(almacenId);
    }
}