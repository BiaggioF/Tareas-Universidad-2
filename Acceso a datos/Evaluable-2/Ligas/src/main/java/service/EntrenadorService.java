package service;

import dao.EntrenadorDAO;
import model.Entrenador;

import java.util.List;

public class EntrenadorService {
    private EntrenadorDAO entrenadorDAO = new EntrenadorDAO();

    // Crear un nuevo entrenador
    public void crearEntrenador(Entrenador entrenador) {
        entrenadorDAO.saveEntrenador(entrenador);
    }

    // Obtener un entrenador por su ID
    public Entrenador obtenerEntrenadorPorId(Long id) {
        return entrenadorDAO.obtenerEntrenadorPorId(id);
    }

    // Obtener todos los entrenadores
    public List<Entrenador> obtenerTodosLosEntrenadores() {
        return entrenadorDAO.obtenerTodosLosEntrenadores();
    }

    // Actualizar los datos de un entrenador
    public void actualizarEntrenador(Entrenador entrenador) {
        entrenadorDAO.actualizarEntrenador(entrenador);
    }

    // Eliminar un entrenador por su ID
    public void eliminarEntrenador(Long id) {
        entrenadorDAO.eliminarEntrenador(id);
    }
}