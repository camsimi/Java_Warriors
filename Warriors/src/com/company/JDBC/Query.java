package com.company.JDBC;
import java.sql.*;
import java.util.Scanner;

/**
 * Classe qui gère les différentes reqûetes SQL du CRUD
 */
public class Query {
    /**
     * On instancie un nouvel objet sc de type Scanner pour récuperer les inputs utilisateur
     */
    private static final Scanner sc = new Scanner(System.in);
    private static Statement state;
    private static PreparedStatement prepare;
    private static ResultSet result;

    /**
     * Afficher les infos de tous les héros présents dans la table HERO
     * @param connect de type Connection pour récupérer la connexion à la BDD
     * @throws SQLException indique que cette méthode peut lever une exception de type SQLException
     */
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

    /**
     * Afficher toutes les infos d'un héro présent dans la table HERO
     * @param connect de type CONNECTION pour récupérer la connexion à la BDD
     * @throws SQLException indique que cette méthode peut lever une exception de type SQLException
     */
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

    /**
     * Créer un nouvel héro dans la table HERO
     * @param connect de type CONNECTION pour récupérer la connexion à la BDD
     * @throws SQLException indique que cette méthode peut lever une exception de type SQLException
     */
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

    /**
     * Met à jour le nom d'un héro avec un input utlisateur
     * @param connect de type CONNECTION pour récupérer la connexion à la BDD
     * @throws SQLException indique que cette méthode peut lever une exception de type SQLException
     */
    public static void updateHero(Connection connect) throws SQLException {
        String query = "UPDATE `Hero` SET `NAME`= ? WHERE NAME = ?";
        PreparedStatement prepare = connect.prepareStatement(query);
        System.out.println("Enter the name of the hero you want to change:");
        String name = sc.nextLine();
        System.out.println("Enter the new name of your hero:");
        String nameUpdated = sc.nextLine();
        prepare.setString(2, name);
        prepare.setString(1, nameUpdated);
        prepare.executeUpdate();
    }

    /**
     * Supprimer un héro selon son ID (passé en paramètre de la méthode)
     * @param connect de type CONNECTION pour récupérer la connexion à la BDD
     * @param id de type entier pour identifier le héro à supprimer de la table
     * @throws SQLException indique que cette méthode peut lever une exception de type SQLException
     */
    public static void deleteHero(Connection connect, int id) throws SQLException {
        String query = " DELETE FROM `Hero` WHERE ID = ?";
        PreparedStatement prepare = connect.prepareStatement(query);
        prepare.setInt(1, id);
        prepare.executeUpdate();
    }

    /**
     * Permet de fermer l'objet state de type Statement
     * Méthode publique et statique qui ne renvoie rien.
     * Pour améliorer les performances en libérant les ressources du pilote
     */
    public static void closeState() {
        try {
            state.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    /**
     * Permet de fermer l'objet prepare de type PrepareStatement
     * Méthode publique et statique qui ne renvoie rien.
     * Pour améliorer les performances en libérant les ressources du pilote
     */
    public static void closePrepare()  {
        try {
            prepare.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    /**
     * Permet de fermer l'objet result de type ResultSet
     * Méthode publique et statique qui ne renvoie rien.
     * Pour améliorer les performances en libérant les ressources du pilote
     */
    public static void closeResult(){
        try {
            result.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
