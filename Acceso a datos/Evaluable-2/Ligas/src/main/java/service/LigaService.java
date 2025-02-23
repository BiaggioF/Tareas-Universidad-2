package service;

import dao.LigaDAO;
import model.Liga;

import java.util.List;

public class LigaService {
    private LigaDAO ligaDAO = new LigaDAO();

    // Crear una nueva liga
    public void crearLiga(Liga liga) {
        ligaDAO.saveLiga(liga);
    }

    // Obtener una liga por su ID
    public Liga obtenerLigaPorId(Long id) {
        return ligaDAO.obtenerLigaPorId(id);
    }

    // Obtener todas las ligas
    public List<Liga> obtenerTodasLasLigas() {
        return ligaDAO.obtenerTodasLasLigas();
    }

    // Actualizar liga
    public void actualizarLiga(Liga liga) {
        ligaDAO.actualizarLiga(liga);
    }

    // Eliminar una liga por su ID
    public void eliminarLiga(Long id) {
        ligaDAO.eliminarLiga(id);
    }
}
