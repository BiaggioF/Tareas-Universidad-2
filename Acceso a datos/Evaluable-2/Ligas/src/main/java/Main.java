
import utils.HibernateUtil;
import model.*;
import service.*;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        // Test de la sesión Hibernate
        HibernateUtil.testSession();

        // Instanciamos los servicios
        LigaService ligaService = new LigaService();
        EquipoService equipoService = new EquipoService();
        JugadorService jugadorService = new JugadorService();
        EntrenadorService entrenadorService = new EntrenadorService();

       // Crear una liga
        Liga liga1 = new Liga("Liga de Fútbol Profesional", LocalDate.parse("2025-01-01"), LocalDate.parse("2025-12-31"));
        ligaService.crearLiga(liga1);
        if (liga1.getId() != null) {
            System.out.println("Liga creada: " + liga1.getNombreLiga() + " con ID: " + liga1.getId());
        } else {
            System.out.println("Error: La liga no fue creada correctamente.");
        }

        Equipo equipo1 = new Equipo("Equipo A", "Madrid", liga1);
        Equipo equipo2 = new Equipo("Equipo B", "Barcelona", liga1);
        Equipo equipo3 = new Equipo("Equipo C", "Valencia", liga1);

        equipoService.crearEquipo(equipo1);
        equipoService.crearEquipo(equipo2);
        equipoService.crearEquipo(equipo3);
        System.out.println("Equipos creados y asociados a la liga:");

        // Crear jugadores y asociarlos a los equipos
        Jugador jugador1 = new Jugador("Jugador A1", "Delantero", 5000000, 20, "España", equipo1);
        Jugador jugador2 = new Jugador("Jugador A2", "Centrocampista", 3000000, 15, "Argentina", equipo1);
        Jugador jugador3 = new Jugador("Jugador B1", "Defensa", 4000000, 10, "Francia", equipo2);
        Jugador jugador4 = new Jugador("Jugador B2", "Portero", 2000000, 5, "Brasil", equipo2);
        Jugador jugador5 = new Jugador("Jugador C1", "Delantero", 6000000, 25, "Italia", equipo3);
        Jugador jugador6 = new Jugador("Jugador C2", "Centrocampista", 3500000, 12, "México", equipo3);
        jugadorService.crearJugador(jugador1);
        jugadorService.crearJugador(jugador2);
        jugadorService.crearJugador(jugador3);
        jugadorService.crearJugador(jugador4);
        jugadorService.crearJugador(jugador5);
        jugadorService.crearJugador(jugador6);

        System.out.println("Jugadores creados y asociados a sus respectivos equipos");

        // Fichar jugadores para otro equipo (ejemplo: mover jugadores de un equipo a otro)
        jugador1.setEquipo(equipo2); // Transferir jugador1 a equipo2
        jugador2.setEquipo(equipo3); // Transferir jugador2 a equipo3
        jugadorService.actualizarJugador(jugador1);
        jugadorService.actualizarJugador(jugador2);

        System.out.println("Jugadores transferidos entre equipos.");

        // Crear entrenadores y asociarlos a los equipos
        Entrenador entrenador1 = new Entrenador("Entrenador A", 9, 10, equipo1);
        Entrenador entrenador2 = new Entrenador("Entrenador B", 8, 5, equipo2);
        Entrenador entrenador3 = new Entrenador("Entrenador C", 7, 3, equipo3);
        entrenadorService.crearEntrenador(entrenador1);
        entrenadorService.crearEntrenador(entrenador2);
        entrenadorService.crearEntrenador(entrenador3);

        System.out.println("Entrenadores creados y asociados a sus respectivos equipos.");

        // Mostrar todos los equipos registrados
        System.out.println("Equipos registrados:");
        for (Equipo equipo : equipoService.obtenerTodosLosEquipos()) {
            // Imprimir solo el nombre del equipo
            System.out.println(equipo.getNombreEquipo());
        }

        // Mostrar jugadores de un equipo específico (Equipo A)
        System.out.println("Jugadores del Equipo B:");
        for (Jugador jugador : jugadorService.obtenerTodosLosJugadores()) {
            // Filtrar por el equipo específico (asegurándose de comparar correctamente el id)
            if (jugador.getEquipo().getId().equals(equipo2.getId())) {
                // Imprimir solo el nombre del jugador
                System.out.println(jugador.getNombre());
            }
        }

// Mostrar equipos de una liga específica (Liga de Fútbol Profesional)
        System.out.println("Equipos de la liga 'Liga de Fútbol Profesional':");
        for (Equipo equipo : equipoService.obtenerEquiposDeLiga(liga1.getId())) {
            // Imprimir solo el nombre del equipo
            System.out.println(equipo.getNombreEquipo());
        }
        // Mostrar entrenadores de los equipos de una liga
        System.out.println("Entrenadores de los equipos de la liga 'Liga de Fútbol Profesional':");

        for (Equipo equipo : equipoService.obtenerEquiposDeLiga(liga1.getId())) {

            Entrenador entrenador = equipo.getEntrenador();

            if (entrenador != null) {
                // Imprimir solo el nombre del entrenador
                System.out.println(entrenador.getNombre());
            }
        }
    }
}


