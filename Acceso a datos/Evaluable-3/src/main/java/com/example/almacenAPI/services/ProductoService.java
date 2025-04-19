package com.example.almacenAPI.services;

import com.example.almacenAPI.model.Producto;

import java.util.List;

public interface ProductoService {
    List<Producto> findAll();
    Producto save(Producto producto);
    void deleteById(Long id);
    List<Producto>findByPrecioLessThan(Double precio);
}
