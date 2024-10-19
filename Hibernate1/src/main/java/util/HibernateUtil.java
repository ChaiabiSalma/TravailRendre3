package util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    // Création d'une instance statique de SessionFactory
    private static final SessionFactory sessionFactory;

    // Bloc statique pour initialiser la SessionFactory au chargement de la classe
    static {
        try {
            // Création de la SessionFactory à partir du fichier de configuration hibernate.cfg.xml
            sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        } catch (Throwable ex) {
            // Log l'exception pour le débogage (à remplacer par un vrai mécanisme de log)
            System.err.println("Échec de la création de SessionFactory: " + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    // Méthode statique pour obtenir la SessionFactory
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}