package com.example.almacenAPI.repository;

import com.example.almacenAPI.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
    List<Producto> findByPrecioLessThan(Double precio);
}
