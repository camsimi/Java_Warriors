package com.company.JDBC;

import java.sql.*;

/**
 * Classe qui gère la connexion à la base de données en utilisant la classe Connection du JDBC
 */
public class Connexion {
    private Connection connect;
    private static Connexion instance;
    private static final String url = "jdbc:mysql://localhost:15501/projet_warrior";
    private static final String user = "camille";
    private static final String password = "Tweezers";

    /**
     * constructeur vide privé pour ne pouvoir instancier d'objet de type Connexion seulement
     * à l'intérieur de ses propres méthodes
     */
    private Connexion(){
    }

    /**
     * Méthode publique et statique qui instancie un nouvel objet instance
     * @return un object de type Connexion
     */
    public static Connexion getInstance() {
        if (instance == null){
            instance = new Connexion();
        }
        return instance;
    }

    /**
     * Méthode publique qui vérifie la présence du driver JDBC et permet la connexion  à la BDD
     * @return un objet de type Connection
     * @throws SQLException indique que cette méthode peut lever une exception de type SQLException
     */
    public Connection getConnect() throws SQLException {
        if ((connect == null) || (connect.isClosed())) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                System.out.println("Driver O.K.");

                connect = DriverManager.getConnection(url, user, password);
                System.out.println("Connexion effective !");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return connect;
    }
}