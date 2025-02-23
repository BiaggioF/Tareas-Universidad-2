package utils;

import model.Liga;
import model.Equipo;
import model.Jugador;
import model.Entrenador;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    private static SessionFactory sessionFactory;

    static {
        try {
            // Crear la SessionFactory con las clases necesarias
            sessionFactory = new Configuration()
                    .configure("hibernate.cfg.xml") // Lee la configuración de hibernate.cfg.xml
                    .addAnnotatedClass(Liga.class)   // Liga
                    .addAnnotatedClass(Equipo.class) // Equipo
                    .addAnnotatedClass(Jugador.class) // Jugador
                    .addAnnotatedClass(Entrenador.class) // Entrenador
                    .buildSessionFactory();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void testSession() {
        try (var session = getSessionFactory().openSession()) {
            System.out.println("Conexión exitosa a la base de datos!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
