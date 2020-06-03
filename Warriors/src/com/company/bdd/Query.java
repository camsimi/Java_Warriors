package com.company.bdd;

import com.company.personnages.Warrior;
import com.company.personnages.Wizard;

import java.nio.channels.SelectableChannel;
import java.sql.*;
import java.util.Scanner;

public class Query {
    private static final Scanner sc = new Scanner(System.in);

    // Récupérer les infos de tous les personnages
    public static void getHeroes(Connection connect) throws SQLException {
        //Création d'un objet Statement
        Statement state = connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        String query = "SELECT * FROM Hero";
        //L'objet ResultSet contient le résultat de la requête SQL
        ResultSet result = state.executeQuery(query);
        //On récupère les MetaData
        ResultSetMetaData resultMeta = result.getMetaData();

        System.out.println("\n*********************************************************************************");
        //On affiche le nom des colonnes
        for (int i = 1; i <= resultMeta.getColumnCount(); i++)
            System.out.print("\t" + resultMeta.getColumnName(i) + " -");

        System.out.println("\n*********************************************************************************");

        while (result.next()) {
            for (int i = 1; i <= resultMeta.getColumnCount(); i++)
                System.out.print("\t" + result.getObject(i).toString().toLowerCase() + "\t |");
                System.out.println("\n------------------------------------------------------------------------------");
        }
    }

    // recup infos d'un perso
    public static void getHero(Connection connect) throws SQLException {
        String query = "SELECT * FROM Hero WHERE ID = ?";
        PreparedStatement prepare = connect.prepareStatement(query);
        prepare.setInt(1, 1);
        ResultSet result = prepare.executeQuery();
        ResultSetMetaData resultMeta = result.getMetaData();
        while (result.next()) {
            for (int i = 1; i < resultMeta.getColumnCount(); i++) {
                System.out.println("\t" + resultMeta.getColumnName(i) + " --> " + result.getObject(i).toString());
            }
        }
    }

    public static void createHero(Connection connect) throws SQLException {
        String query = "INSERT INTO `Hero`(`TYPE`, `NAME`, `LIFE`, `STRENGTH`, `WEAPON/SPELL`, `POTION`) VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement prepare = connect.prepareStatement(query);
        System.out.println("Please enter a type between Wizard and Warrior to your hero.");
        String type = sc.nextLine().toLowerCase();
        System.out.println("Please enter a new name to your hero.");
        String name = sc.nextLine();
        System.out.println("Please enter life points to your hero.");
        int life = sc.nextInt();
        System.out.println("Please enter strength points to your hero.");
        int strength = sc.nextInt();
        String ws;
        if (type.equals("wizard")) {
            System.out.println("Please enter a Spell (between Eclair and Fire) to your hero.");
        } else {
            System.out.println("Please enter a Weapon (between Massue and Epee) to your hero.");
        }
        String entree = sc.nextLine();
        ws = sc.nextLine();

        System.out.println("Please enter a Potion between (StandardPotion and BigPotion) to your hero.");
        String potion = sc.nextLine();
        prepare.setString(1, type);
        prepare.setString(2, name);
        prepare.setInt(3, life);
        prepare.setInt(4, strength);
        prepare.setString(5, ws);
        prepare.setString(6, potion);
        prepare.executeUpdate();
    }

    public static void updateHero(Connection connect, int id) throws SQLException {
        String query = "UPDATE `Hero` SET `LIFE`= 10,`STRENGTH`= 10 WHERE ID = ?";
        PreparedStatement prepare = connect.prepareStatement(query);
        prepare.setInt(1, id);
//            result.updateString("NAME", "Girlic");
//            infosPerso.updateInt("LIFE", 12);
//            infosPerso.updateRow();
//            System.out.println("Infos perso à l'ID 2 après modifications:");
//            System.out.println("NAME: " + infosPerso.getString("NAME") + ", LIFE: " + infosPerso.getInt("LIFE"));
    }

    public static void deleteHero(int id) {
//        DELETE FROM `Hero` WHERE 0
    }
}
