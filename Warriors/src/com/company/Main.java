package com.company;

import com.company.bdd.Connexion;
import com.company.bdd.Query;
import com.company.personnages.Perso;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        try {

//            Query.getHero(Connexion.getInstance());
//            Query.createHero(Connexion.getInstance());
            Query.getHeroes(Connexion.getInstance());
        } catch (SQLException e) {
            e.printStackTrace();
        }
//        finally {
//            state.close();
//            result.close();
//        }


//        // Instancie un nouveau menu
//        Menu menu = new Menu();
//        // Afficher le choix du menu (quitter ou créer un perso)
//        menu.display();
//        // Instancie une nouvelle partie
//        Game game = new Game();
//        // Choisir entre les différentes options et stocker le retour Wizard/Warrior dans une variable
//        String persoType = menu.chooseMenu(game);
//        // Create perso with type, name and display his informations
//        Perso perso = game.createPerso(menu, persoType);
//        // Lancer la partie
//        game.play(menu, perso);
    }
}


