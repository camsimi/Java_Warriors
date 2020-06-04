package com.company.bdd;

import java.sql.*;

public class Connexion {
    private Connection connect;
    private static Connexion instance;
    private static final String url = "jdbc:mysql://localhost:15501/projet_warrior";
    private static final String user = "camille";
    private static final String password = "Tweezers";

    private Connexion(){
    }

    public static Connexion getInstance() {
        if (instance == null){
            instance = new Connexion();
        }
        return instance;
    }

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