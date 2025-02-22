package service;

import dao.JugadorDAO;
import model.Jugador;

import java.util.List;

public class JugadorService {
    private JugadorDAO jugadorDAO = new JugadorDAO();

    // Crear un nuevo jugador
    public void crearJugador(Jugador jugador) {
        jugadorDAO.saveJugador(jugador);
    }

    // Obtener un jugador por su ID
    public Jugador obtenerJugadorPorId(Long id) {
        return jugadorDAO.obtenerJugadorPorId(id);
    }

    // Obtener todos los jugadores
    public List<Jugador> obtenerTodosLosJugadores() {
        return jugadorDAO.obtenerTodosLosJugadores();
    }

    // Actualizar jugador
    public void actualizarJugador(Jugador jugador) {
        jugadorDAO.actualizarJugador(jugador);
    }

    // Eliminar un jugador por su ID
    public void eliminarJugador(Long id) {
        jugadorDAO.eliminarJugador(id);
    }
}