package com.company.bdd;

import java.sql.*;

public class Connexion {
    protected static Connection con;

    public static void connect() throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver O.K.");
            String url = "jdbc:mysql://localhost:15501/projet_warrior";
            String user = "camille";
            String password = "Tweezers";

            con = DriverManager.getConnection(url, user, password);
            System.out.println("Connexion effective !");
            //Création d'un objet Statement
            Statement state = con.createStatement();
            // Récupérer les infos de tous les personnages
            //L'objet ResultSet contient le résultat de la requête SQL
            ResultSet infosPersos = state.executeQuery(Query.getHeroes());
            //On récupère les MetaData
            ResultSetMetaData resultMeta = infosPersos.getMetaData();
            // Afficher les infos de tous les personnages
            while (infosPersos.next()) {
                for (int i = 1; i < resultMeta.getColumnCount(); i++) {
                    System.out.println("\t" + resultMeta.getColumnName(i) + " --> " + infosPersos.getObject(i).toString());
                }
            }
            // recup infos un perso
            ResultSet infosPerso = state.executeQuery(Query.getHero());
                for (int i = 1; i < resultMeta.getColumnCount(); i++) {
                    System.out.println("\t" + resultMeta.getColumnName(i) + " --> " + infosPerso.getObject(i).toString());
                }

            infosPerso.close();
            state.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
