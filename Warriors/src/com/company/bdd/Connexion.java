package com.company.bdd;

import java.sql.*;

public class Connexion {
    private static Connection connect;
    private static final String url = "jdbc:mysql://localhost:15501/projet_warrior";
    private static final String user = "camille";
    private static final String password = "Tweezers";

    public static Connection getInstance() {
        if (connect == null) {
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