package com.company;

import com.company.personnages.Perso;
import com.company.personnages.PersonnageHorsPlateauException;
import com.company.personnages.Warrior;
import com.company.personnages.Wizard;

import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    // attribut qui stocke la position du joueur
    int posPlayer = 0;
    int tour = 0;
    int dice = 0;
    Plateau plateau = new Plateau();
    // attribut qui stocke la longueur du plateau
    int plateauLength = plateau.getPlateauLength();

    // Instancie un nouveau Scanner pour récupérer les inputs
    Scanner sc = new Scanner(System.in);

    public String chooseType(Menu menu) {
        String persoType = "";
        do {
            System.out.println("Please choose your persoType: type Wizard or Warrior :");
            persoType = sc.nextLine().toLowerCase();
            if (persoType.equals("wizard")) {
                System.out.println("You chose to be a : " + persoType);
            } else if (persoType.equals("warrior")) {
                System.out.println("You chose to be a : " + persoType);
            } else if (persoType.equals("quit") || persoType.equals("quitter")) {
                menu.quit();
            } else {
                System.out.println("You have to choose between Wizard and Warrior. \n Type 'quit' to quit the game. ");
            }
        } while ((!persoType.equals("wizard")) && (!persoType.equals("warrior")));
        return persoType;
    }

    // on récupère le user input pour le nom du personnage
    private String chooseName() {
        System.out.println("Please enter your perso name: ");
        return sc.nextLine();
    }

    // on instancie un nouveau perso à partir de la classe Warrior ou Wizard en fonction du user input
    private Perso instanciatePerso(String persoType, String persoName) {
        Perso personnage;
        if (persoType.equals("warrior")) {
            personnage = new Warrior(persoName);
        } else {
            personnage = new Wizard(persoName);
        }
        return personnage;
    }

    // on propose un choix à l'utilisateur entre voir les infos du perso ou quitter
    public void displayPerso(Perso perso, Menu menu) {
        System.out.println("If you want to see your perso informations, press 'y'");
        String response = sc.nextLine().toLowerCase();
        if (response.equals("y")) {
            System.out.println(perso.toString());
        } else if (response.equals("quit")) {
            menu.quit();
        }
    }

    // on crée un perso en instanciant son type et avec le nom saisi en input
    public Perso createPerso(Menu menu, String persoType) {
        // Choisir un nom au perso et le stocker dans une variable
        String persoName = this.chooseName();
/*Créer un nouveau perso (instancier un Warrior/Wizard à partir de la classe Perso)
 avec en paramètre le Scanner, le type et le nom du perso */
        Perso perso = this.instanciatePerso(persoType, persoName);
// Afficher les infos du perso en récupérant l'objet perso et le Scanner en paramètres.
        this.displayPerso(perso, menu);
        return perso;
    }

    private int giveDice(int min, int max) {
        return (int) Math.floor(Math.random() * (max - min + 1)) + min;
    }

    private void controle(int result) throws PersonnageHorsPlateauException {
        if (result > 64)
            throw new PersonnageHorsPlateauException();
    }

    private void jouer_un_tour(Perso perso) {
        // incrémente le nombre de tour
        tour = tour + 1;
        // lance le dé au hasard
        dice = this.giveDice(1, 6);
        try {
            controle(posPlayer += dice);
        } catch (PersonnageHorsPlateauException e) {
            posPlayer = plateauLength;
            System.out.println(e.getMessage());
        }
// Si le joueur n'a pas atteint la case 64
        if (posPlayer != plateauLength) {
// récupération de la case courante avec la position du joueur
            Case CaseCourante = plateau.getCase(posPlayer);
            System.out.println("Case " + posPlayer + "/64 " + CaseCourante.toString());
// Interaction de la case avec le personnage
            CaseCourante.interact(perso);
// Affichage infos/attributs perso
            System.out.println(perso.toString());
            System.out.println("-----------------------------------------------------");
        }

        // lancer un combat
        // mettre à jour le statut d'avancement du jeu (en cours/quitter la partie/perso mort,...)
        // gérer plusieurs joueurs
    }

    public void play(Menu menu, Perso perso) {
        // plateau aléatoire
        plateau.mix();
        System.out.println("-----------------------------------------------------");
        do {
            jouer_un_tour(perso);
            sc.nextLine();
// tant que la position du joueur est inférieure à la dernière case du plateau, boucler sur le code précédent
        } while (posPlayer < plateauLength);
        if (posPlayer == plateauLength) {

            System.out.println("Case 64/64: Tu as gagné!");
// affichage du choix entre quitter et créer un nouveau perso
            menu.chooseMenu(this);
        }
    }
}
