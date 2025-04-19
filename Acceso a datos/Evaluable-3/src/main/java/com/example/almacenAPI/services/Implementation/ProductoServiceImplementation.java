package com.example.almacenAPI.services.Implementation;

import com.example.almacenAPI.model.Producto;
import com.example.almacenAPI.repository.ProductoRepository;
import com.example.almacenAPI.repository.TrabajadorRepository;
import com.example.almacenAPI.services.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductoServiceImplementation implements ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    @Override
    public List<Producto> findAll() {
        return productoRepository.findAll();
    }

    @Override
    public Producto save(Producto producto) {
        return productoRepository.save(producto);
    }

    @Override
    public void deleteById(Long id) {
        productoRepository.deleteById(id);
    }

    @Override
    public List<Producto> findByPrecioLessThan(Double precio) {
        return productoRepository.findByPrecioLessThan(precio);
    }
}
