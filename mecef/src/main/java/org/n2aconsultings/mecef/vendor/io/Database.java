package org.n2aconsultings.mecef.vendor.io;

import lombok.Getter;
import org.n2aconsultings.mecef.view.AlertError;

import java.sql.Connection;
import java.sql.DriverManager;

@Getter
public class Database
{
    private Connection connection;
    
    public Database() {
        final String DRIVER = "org.h2.Driver";
        final String JDBC_URL = "jdbc:h2:./resources/mecef";
        final String USERNAME = "sa";
        final String PASSWORD = "Mecef+229";

        try {
            Class.forName(DRIVER);
            this.connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
        }
        catch (Exception e) {
            e.printStackTrace();
            AlertError.getInstance().setTitle("Erreur");
            AlertError.getInstance().setHeaderText("Echec connexion");
            AlertError.getInstance().setContentText("Echec lors de la connexion à la base de données :" + e.getMessage());
            AlertError.getInstance().showAndWait();
        }
    }
}