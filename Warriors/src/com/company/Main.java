package com.company;
import com.company.personnages.Perso;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
// Instancie un nouveau menu
        Menu menu = new Menu();
// Afficher le choix du menu (quitter ou créer un perso)
        menu.display();
// Instancie une nouvelle partie
        Game game = new Game();
// Choisir entre les différentes options et stocker le retour Wizard/Warrior dans une variable
        String persoType = menu.chooseMenu(game);
// Create perso with type, name and display his informations
        Perso perso = game.createPerso(menu, persoType);
// Lancer la partie
        game.play(menu, perso);
    }
}


