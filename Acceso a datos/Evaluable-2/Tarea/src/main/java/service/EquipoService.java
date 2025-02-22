package service;

import dao.EquipoDAO;
import model.Equipo;

import java.util.List;

public class EquipoService {
    private EquipoDAO equipoDAO = new EquipoDAO();

    // Crear un nuevo equipo
    public void crearEquipo(Equipo equipo) {
        equipoDAO.saveEquipo(equipo);
    }

    // Obtener un equipo por su ID
    public Equipo obtenerEquipoPorId(Long id) {
        return equipoDAO.obtenerEquipoPorId(id);
    }

    // Obtener todos los equipos
    public List<Equipo> obtenerTodosLosEquipos() {
        return equipoDAO.obtenerTodosLosEquipos();
    }

    // Actualizar equipo
    public void actualizarEquipo(Equipo equipo) {
        equipoDAO.actualizarEquipo(equipo);
    }

    // Eliminar un equipo por su ID
    public void eliminarEquipo(Long id) {
        equipoDAO.eliminarEquipo(id);
    }

    // Obtener los equipos de una liga
    public List<Equipo> obtenerEquiposDeLiga(Long ligaId) {
        return equipoDAO.obtenerEquiposDeLiga(ligaId);
    }
}
