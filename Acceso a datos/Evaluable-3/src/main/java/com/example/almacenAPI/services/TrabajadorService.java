package com.example.almacenAPI.services;

import com.example.almacenAPI.model.Trabajador;

import java.util.List;
import java.util.Optional;

public interface TrabajadorService {
    List<Trabajador>findAll();
    Optional <Trabajador >findById(Integer id);
    List<Trabajador> findByEdadGreaterThan(int edad);
    List<Trabajador> findByEdadLessThan(int edad);
    List<Trabajador> findByNacionalidad(String nacionalidad);
    Integer countByEdadGreaterThan(int edad);
    Integer countByEdadLessThan(int edad);
    Trabajador save(Trabajador trabajador);
    void deleteById(Integer id);
}
