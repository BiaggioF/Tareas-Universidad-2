package com.example.almacenAPI.repository;

import com.example.almacenAPI.model.Produccion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProduccionRepository extends JpaRepository<Produccion, Long> {
        List<Produccion> findByTrabajadorId(Integer trabajadorId);
        List<Produccion> findByAlmacenId(Integer almacenId);
}
