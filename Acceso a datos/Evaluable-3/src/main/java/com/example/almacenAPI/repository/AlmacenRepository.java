package com.example.almacenAPI.repository;

import com.example.almacenAPI.model.Almacen;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AlmacenRepository extends JpaRepository<Almacen, Integer> {
    List<Almacen> findByNombreAlmacenContaining(String texto);
}
