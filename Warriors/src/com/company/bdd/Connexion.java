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
//            //Création d'un objet Statement
//            Statement state = con.createStatement();
//            // Récupérer les infos de tous les personnages
//            //L'objet ResultSet contient le résultat de la requête SQL
//            ResultSet result = state.executeQuery(Query.getHeroes());
//            //On récupère les MetaData
//            ResultSetMetaData resultMeta = result.getMetaData();
//            // Afficher les infos de tous les personnages
//            while (result.next()) {
//                for (int i = 1; i < resultMeta.getColumnCount(); i++) {
//                    System.out.println("\t" + resultMeta.getColumnName(i) + " --> " + result.getObject(i).toString());
//                }
//            }
//            // recup infos d'un perso
//            ResultSet infosPerso = state.executeQuery(Query.getHero());
//                for (int i = 1; i < resultMeta.getColumnCount(); i++) {
//                    System.out.println("\t" + resultMeta.getColumnName(i) + " --> " + infosPerso.getObject(i).toString());
//                }

            // Update infos perso
//            infosPerso.updateString("NAME", "Girlic");
//            infosPerso.updateInt("LIFE", 12);
//            infosPerso.updateRow();
//            System.out.println("Infos perso à l'ID 2 après modifications:");
//            System.out.println("NAME: " + infosPerso.getString("NAME") + ", LIFE: " + infosPerso.getInt("LIFE"));

//            infosPerso.close();
//            state.close();
