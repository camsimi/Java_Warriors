package com.company.bdd;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connexion {
    protected Connection conn;

    public static void connect() {
        Connection conn;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver O.K.");
            String url = "jdbc:mysql://localhost:15501/projet_warrior";
            String user = "camille";
            String password = "Tweezers";

            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connexion effective !");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
