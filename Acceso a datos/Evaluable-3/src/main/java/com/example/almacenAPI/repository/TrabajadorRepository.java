package com.example.almacenAPI.repository;

import com.example.almacenAPI.model.Trabajador;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TrabajadorRepository extends JpaRepository<Trabajador, Integer> {

    List<Trabajador> findByEdadGreaterThan(int edad);
    List<Trabajador> findByEdadLessThan(int edad);
    List<Trabajador> findByNacionalidad(String nacionalidad);

    Integer countByEdadGreaterThan(int edad);

    Integer countByEdadLessThan(int edad);

}
