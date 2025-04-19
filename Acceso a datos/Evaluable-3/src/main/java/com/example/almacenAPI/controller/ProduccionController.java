package com.example.almacenAPI.controller;

import com.example.almacenAPI.model.Produccion;
import com.example.almacenAPI.services.ProduccionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/producciones")
public class ProduccionController {

    @Autowired
    private ProduccionService produccionService;

    @GetMapping
    public List<Produccion> getAll() {
        return produccionService.findAll();
    }

    @GetMapping("/trabajador/{id}")
    public List<Produccion> porTrabajador(@PathVariable Integer id) {
        return produccionService.findByTrabajadorId(id);
    }

    @GetMapping("/almacen/{id}")
    public List<Produccion> porAlmacen(@PathVariable Integer id) {
        return produccionService.findByAlmacenId(id);
    }

    @PostMapping
    public Produccion create(@RequestBody Produccion produccion) {
        return produccionService.save(produccion);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        produccionService.deleteById(id);
        return ResponseEntity.ok("Producción eliminada");
    }
}
