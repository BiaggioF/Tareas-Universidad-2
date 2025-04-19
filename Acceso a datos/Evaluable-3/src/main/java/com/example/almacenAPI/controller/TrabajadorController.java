package com.example.almacenAPI.controller;

import com.example.almacenAPI.model.Trabajador;
import com.example.almacenAPI.services.TrabajadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/trabajadores")
public class TrabajadorController {
    @Autowired
    private TrabajadorService trabajadorService;

    @GetMapping
    public List<Trabajador>getAll(){
        return trabajadorService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Trabajador> getById(@PathVariable Integer id) {
        return trabajadorService.findById(id)
                .map(ResponseEntity::ok)                    // 200 + body si está
                .orElse(ResponseEntity.notFound().build()); // 404 si no existe
    }

    @GetMapping("/mayores/{edad}")
    public List<Trabajador> getMayoresDe(@PathVariable int edad) {
        return trabajadorService.findByEdadGreaterThan(edad);
    }

    @GetMapping("/menores/{edad}")
    public List<Trabajador>getMenoresDe(@PathVariable int edad) {
        return  trabajadorService.findByEdadLessThan(edad);
    }

    @GetMapping("/nacionalidad/{nacionalidad}")
    public List<Trabajador> getPorNacionalidad(@PathVariable String nacionalidad) {
        return trabajadorService.findByNacionalidad(nacionalidad);
    }

    @GetMapping("/conteo/mayores/{edad}")
    public long countMayoresDe(@PathVariable int edad) {
        return trabajadorService.countByEdadGreaterThan(edad);
    }

    // Conteo de menores de X años
    @GetMapping("/conteo/menores/{edad}")
    public long countMenoresDe(@PathVariable int edad) {
        return trabajadorService.countByEdadLessThan(edad);
    }
    //Crear un nuevo trabajador
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Trabajador create(@RequestBody Trabajador trabajador) {
        return trabajadorService.save(trabajador);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id) {
        trabajadorService.deleteById(id);
        return ResponseEntity
                .ok("Trabajador eliminado correctamente");
    }
}
