package com.example.almacenAPI.controller;

import com.example.almacenAPI.model.Producto;
import com.example.almacenAPI.services.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @GetMapping
    public List<Producto> getAll() {
        return productoService.findAll();
    }

    @GetMapping("/precio/menor/{precio}")
    public List<Producto> getBaratos(@PathVariable Double precio) {
        return productoService.findByPrecioLessThan(precio);
    }

    @PostMapping
    public Producto create(@RequestBody Producto producto) {
        return productoService.save(producto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        productoService.deleteById(id);
        return ResponseEntity.ok("Producto eliminado");
    }
}
