package org.n2aconsultings.mecef.vendor.io;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.n2aconsultings.mecef.view.AlertError;

public class HibernateJpa {

    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        try {
            Configuration configuration = new Configuration();
            configuration.configure();
            sessionFactory = configuration.buildSessionFactory();
        } catch (Exception e) {
            AlertError.getInstance().setTitle("Erreur");
            AlertError.getInstance().setHeaderText("Connexion avec la base de donnée");
            AlertError.getInstance().setContentText("Problème à l'ouverture de la session : \n" + e.getMessage());
            AlertError.getInstance().showAndWait();
            e.printStackTrace();
        }
        return sessionFactory;
    }
}
