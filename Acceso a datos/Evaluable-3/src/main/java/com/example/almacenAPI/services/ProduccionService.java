package com.example.almacenAPI.services;

import com.example.almacenAPI.model.Produccion;
import java.util.List;

public interface ProduccionService {
    List<Produccion> findAll();
    Produccion save(Produccion produccion);
    void deleteById(Long id);
    List<Produccion> findByTrabajadorId(Integer trabajadorId);
    List<Produccion> findByAlmacenId(Integer almacenId);
}