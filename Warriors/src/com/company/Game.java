package com.company;

import com.company.personnages.Perso;
import com.company.personnages.Warrior;
import com.company.personnages.Wizard;

import java.util.Scanner;

public class Game {
    int posPlayer = 0;
    int plateau = 64;
    int tour = 0;
    int dice = 0;
    //    Plateau ArrayList<Case> plateau;
//    Plateau plateau;
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
    public String chooseName() {
        System.out.println("Please enter your perso name: ");
        return sc.nextLine();
    }

    // on instancie un nouveau perso à partir de la classe Warrior ou Wizard en fonction du user input
    public Perso instanciatePerso(String persoType, String persoName) {
        Perso personnage;
        if (persoType.equals("Warrior")) {
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
    public void createPerso(Menu menu, String persoType) {
        // Choisir un nom au perso et le stocker dans une variable
        String persoName = this.chooseName();
/*Créer un nouveau perso (instancier un Warrior/Wizard à partir de la classe Perso)
 avec en paramètre le Scanner, le type et le nom du perso */
        Perso perso = this.instanciatePerso(persoType, persoName);
// Afficher les infos du perso en récupérant l'objet perso et le Scanner en paramètres.
        this.displayPerso(perso, menu);
    }

    public void jouer_un_tour() {
        // incrémente le nombre de tour
        tour = tour + 1;
        // lance le dé au hasard
        dice = this.giveDice(1, 6);
        // si la somme du résultat du dé avec la position du joueur est supérieure aux nombres de cases du plateau
        if (dice + posPlayer > plateau) {
//                throw new PersonnageHorsPlateauException();
            // le joueur avance sur la case 64
            posPlayer = plateau;
            // sinon on fait la somme du dé avec la position du joueur
        } else {
            posPlayer += dice;
        }
        System.out.println("Le joueur est sur la case " + posPlayer + "/64");
        // interagir avec le plateau
        // s'équiper d'un bonus
        // lancer un combat
        // mettre à jour le statut d'avancement du jeu (en cours/quitter la partie/perso mort,...)
        // gérer plusieurs joueurs
    }

    public int giveDice(int min, int max) {
        return (int) Math.floor(Math.random() * (max - min + 1)) + min;
    }

    public void play(Menu menu) {
        do {
            jouer_un_tour();
            // tant que la position du joueur est inférieure à la dernière case du plateau, boucler sur le code précédent
        } while (posPlayer < plateau);
        if (posPlayer == plateau) {
            System.out.println("Tu as gagné!");
            // affichage du choix entre quitter et créer un nouveau perso
            menu.chooseMenu(this);
        }
    }
}
