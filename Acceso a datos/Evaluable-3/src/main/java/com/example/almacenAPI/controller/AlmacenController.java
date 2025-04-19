package com.example.almacenAPI.controller;

import com.example.almacenAPI.model.Almacen;
import com.example.almacenAPI.services.AlmacenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/almacenes")
public class AlmacenController {
    @Autowired
    private AlmacenService almacenService;


    @GetMapping
    public List<Almacen> getAll() {
        return almacenService.findAll();
    }

    @GetMapping("/buscar")
    public List<Almacen> buscarPorNombre(@RequestParam String texto) {
        return almacenService.findByNombreContaining(texto);
    }

    @PostMapping
    public Almacen create(@RequestBody Almacen almacen) {
        return almacenService.save(almacen);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id) {
        almacenService.deleteById(id);
        return ResponseEntity.ok("Almacén eliminado");
    }
}
