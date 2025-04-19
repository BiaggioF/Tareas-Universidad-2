package com.example.almacenAPI.services.Implementation;

import com.example.almacenAPI.model.Almacen;
import com.example.almacenAPI.repository.AlmacenRepository;
import com.example.almacenAPI.services.AlmacenService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AlmacenServiceImplementation implements AlmacenService {

    private final AlmacenRepository repo;

    public AlmacenServiceImplementation(AlmacenRepository repo) {
        this.repo = repo;
    }

    @Override
    public List<Almacen> findAll() {
        return repo.findAll();
    }

    @Override
    public Almacen save(Almacen almacen) {
        return repo.save(almacen);
    }

    @Override
    public void deleteById(Integer id) {
        repo.deleteById(id);
    }

    @Override
    public List<Almacen> findByNombreContaining(String texto) {
        return repo.findByNombreAlmacenContaining(texto);
    }
}
