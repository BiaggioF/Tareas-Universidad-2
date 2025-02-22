package dao;

import model.Entrenador;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateUtil;

import java.util.List;

public class EntrenadorDAO {

    // Método para guardar un nuevo entrenador
    public void saveEntrenador(Entrenador entrenador) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(entrenador);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    // Obtener entrenador por ID
    public Entrenador obtenerEntrenadorPorId(Long id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Entrenador.class, id);
        }
    }

    // Obtener todos los entrenadores
    public List<Entrenador> obtenerTodosLosEntrenadores() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM Entrenador", Entrenador.class).list();
        }
    }

    // Actualizar entrenador
    public void actualizarEntrenador(Entrenador entrenador) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(entrenador);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    // Eliminar entrenador
    public void eliminarEntrenador(Long id) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Entrenador entrenador = session.get(Entrenador.class, id);
            if (entrenador != null) {
                session.delete(entrenador);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
}