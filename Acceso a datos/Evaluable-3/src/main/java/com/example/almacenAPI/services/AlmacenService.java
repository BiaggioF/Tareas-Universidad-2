package com.example.almacenAPI.services;

import com.example.almacenAPI.model.Almacen;
import java.util.List;

public interface AlmacenService {
    List<Almacen> findAll();
    Almacen save(Almacen almacen);
    void deleteById(Integer id);
    List<Almacen> findByNombreContaining(String texto);
}