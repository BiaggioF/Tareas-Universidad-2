package service;

import dao.EquipoDAO;
import model.Equipo;

import java.util.List;

public class EquipoService {
    private EquipoDAO equipoDAO = new EquipoDAO();


    public void crearEquipo(Equipo equipo) {
        equipoDAO.saveEquipo(equipo);
    }


    public Equipo obtenerEquipoPorId(Long id) {
        return equipoDAO.obtenerEquipoPorId(id);
    }


    public List<Equipo> obtenerTodosLosEquipos() {
        return equipoDAO.obtenerTodosLosEquipos();
    }


    public void actualizarEquipo(Equipo equipo) {
        equipoDAO.actualizarEquipo(equipo);
    }


    public void eliminarEquipo(Long id) {
        equipoDAO.eliminarEquipo(id);
    }


    public List<Equipo> obtenerEquiposDeLiga(Long ligaId) {
        return equipoDAO.obtenerEquiposDeLiga(ligaId);
    }
}
