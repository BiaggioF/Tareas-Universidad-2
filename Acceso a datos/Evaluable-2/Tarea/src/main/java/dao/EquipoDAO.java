package dao;

import model.Equipo;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateUtil;

import java.util.List;

public class EquipoDAO {

    // Guardar un equipo en la base de datos
    public void saveEquipo(Equipo equipo) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(equipo);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    // Obtener equipo por ID
    public Equipo obtenerEquipoPorId(Long id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Equipo.class, id);
        }
    }

    // Obtener todos los equipos
    public List<Equipo> obtenerTodosLosEquipos() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM Equipo", Equipo.class).list();
        }
    }

    // Actualizar equipo
    public void actualizarEquipo(Equipo equipo) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(equipo);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    // Eliminar equipo por ID
    public void eliminarEquipo(Long id) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Equipo equipo = session.get(Equipo.class, id);
            if (equipo != null) {
                session.delete(equipo);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    // Obtener los equipos de una liga
    public List<Equipo> obtenerEquiposDeLiga(Long ligaId) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM Equipo e WHERE e.liga.id = :ligaId", Equipo.class)
                    .setParameter("ligaId", ligaId)
                    .list();
        }
    }
}