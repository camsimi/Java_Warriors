package com.company;

import com.company.ennemis.Ennemi;
import com.company.personnages.Perso;
import com.company.personnages.Warrior;
import com.company.personnages.Wizard;
import com.company.plateau.Case;
import com.company.plateau.Plateau;

import java.util.Scanner;

/**
 * Représente le déroulé du jeu avec plusieurs méthodes qui servent à créer un nouveau personnage, à quitter le jeu,
 * à joueur un tour, à lancer le dé, prendre une décision entre combattre ou fuir, et afficher les infos du personnage.
 *
 * <p>
 * Il est caractérisé par les attributs suivants: </p>
 * <ul>
 *     <li>Un plateau de type Plateau qui contient toutes les cases</li>
 *     <li>Un entier qui stocke la taille du plateau</li>
 *     <li>Un objet de type Scanner qui récupère les inputs utilisateur</li>
 * </ul>
 *
 * Les méthodes de cette classe sont appelé dans le main de la classe Main
 * @see Main
 *
 * @author camille
 * @version 1.0
 *
 */
public class Game {
//    private int dice = 0;
    // on instancie un nouvel objet plateau qui contient les cases
    Plateau plateau = new Plateau();
    // attribut qui stocke la longueur du plateau
    private final int plateauLength = plateau.getPlateauLength();
    // Instancie un nouveau Scanner pour récupérer les inputs
    Scanner sc = new Scanner(System.in);

    /**
     * Méthode qui permet de récupérer le type de personnage (wizard/warrior) avec un input utilisateur
     * @param menu de type Menu pour pouvoir accéder aux méthodes de l'instance menu comme quit()
     * @return chaîne de caractère: Wizard ou Warrior, le type de personnage choisi par l'utilisateur
     */
    public String chooseType(Menu menu) {
        String persoType = "";
        do {
            System.out.println("Please choose your persoType: type Wizard or Warrior :");
            persoType = sc.nextLine().toLowerCase();
            if ((persoType.equals("wizard") || (persoType.equals("warrior")))) {
                System.out.println("You chose to be a : " + persoType);
            } else if (persoType.equals("quit") || persoType.equals("quitter")) {
                menu.quit();
            } else {
                System.out.println("You have to choose between Wizard and Warrior. \n Type 'quit' to quit the game. ");
            }
        } while ((!persoType.equals("wizard")) && (!persoType.equals("warrior")));
        return persoType;
    }

    /**
     * Récupère le user input pour le nom du personnage
     * @return le nom du personnage sous la forme d'une chaîne de caractères
     */
    private String chooseName() {
        System.out.println("Please enter your perso name: ");
        return sc.nextLine();
    }

    /**
     * Nouveau perso (wizard ou warrior) instancé à partir des inputs utilisateurs (type et nom)
     * @param persoType wizard ou warrior de type chaîne de caractère
     * @param persoName nom du personnage de type chaîne de caractère
     * @return un personnage de type Perso (Wizard ou Warrior)
     */
    private Perso instanciatePerso(String persoType, String persoName) {
        Perso personnage;
        if (persoType.equals("warrior")) {
            personnage = new Warrior(persoName);
        } else {
            personnage = new Wizard(persoName);
        }
        return personnage;
    }

    /**
     * Choix entre afficher les infos du personnage ou quitter le jeu
     * @param perso de type Perso pour accéder à ses infos et sa méthode toString
     * @param menu de type Menu pour accéder à sa méthode quit()
     */
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

    /**
     * Création nouveau personnage en appelant la méthode instanciatePerso()
     * @param menu de type Menu
     * @param persoType de type chaîne de caractère
     * @return une personnage de type Perso
     */
    // on crée un perso en instanciant son type et avec le nom saisi en input
    public Perso createPerso(Menu menu, String persoType) {
        // Choisir un nom au perso et le stocker dans une variable
        String persoName = this.chooseName();
        /*Créer un nouveau perso (instancier un Warrior/Wizard à partir de la classe Perso)
        avec en paramètre le type et le nom du perso */
        Perso perso = this.instanciatePerso(persoType, persoName);
        // Afficher les infos du perso en récupérant les objets perso et menu en paramètres.
        this.displayPerso(perso, menu);
        // retourne un objet perso de type Perso
        return perso;
    }

    /**
     * Méthode qui permet de simuler un lancé de dé à 6 face
     * @return le résultat aléatoire du dé de type entier
     */
    private int giveDice() {
        return (int) Math.floor(Math.random() * (6 - 1 + 1)) + 1;
    }

    /**
     * Méthode permettant de lever une exception en cas de sorti du plateau (< 0 et > 64)
     * @param result de type entier soit le calcul résultant de la position du joueur sur le plateau
     * @throws PersonnageHorsPlateauException qui gère quand le perso sort du plateau (<0 et >64)
     */
    private void controle(int result) throws PersonnageHorsPlateauException {
        // Si le joueur sort du plateau (en-dessous de 0, et au-dessus de 64)
        if ((result > 64) || (result < 0))
            // Appeler l'exception
            throw new PersonnageHorsPlateauException();
    }

    /**
     * Méthode qui contient le déroulé d'un tour complet, lancer de dé, avancement du personnage, interaction avec les cases
     * @param perso de type Perso pour appeler ses méthodes qui permettent de récupérer et modifier la position du joueur,
     * d'afficher ses informations
     */
    private void jouer_un_tour(Perso perso) {
        // lance le dé au hasard et stocke le résultat dans la variable dice
        int dice = this.giveDice();
        System.out.println("...**********.....");
        // affiche l'avancement en nombre de cases
        System.out.println("Avance de " + dice + " case(s).");
        // Représentation graphique de l'avancement du joueur
        System.out.println("...**********.....");
        // Test exception
        try {
            controle(perso.getPosition() + dice);
            // on additionne la position du joueur et le résultat du dé
            perso.setPosition(perso.getPosition() + dice);
        // capture exception
        } catch (PersonnageHorsPlateauException e) {
            // Si exception interceptée le joueur va sur la case 64
            perso.setPosition(plateauLength);
            // on affiche le message d'erreur
            System.out.println(e.getMessage());
        }
        // Si le joueur n'a pas atteint la case 64
        if (perso.getPosition() != plateauLength) {
            // récupération de la case courante avec la position du joueur
           Case caseCourante = plateau.getCase(perso.getPosition());
            // Interaction de la case avec le personnage
            decision(perso, caseCourante);
            // Affichage infos/attributs perso
            System.out.println(perso.toString());
//            // Délimitation graphique des cases
//            System.out.println("-----------------------------------------------------");
        }
    }

    /**
     * Méthode qui permet au personnage de combattre ou de fuir en fonction du choix de l'utilisateur
     * @param perso de type Perso pour utiliser notamment sa méthode fuir()
     * @param caseCourante de type Case pour mettre à jour la case courante
     */
    private void decision(Perso perso, Case caseCourante) {
        // variable qui récupère une chaîne de caractère qui contient c (pour combattre) ou e (pour fuir)
        String choice;
        // affichage du numéro de la case courante et de ses infos
        System.out.println("Case " + perso.getPosition() + "/64 " + caseCourante.toString());
        // Si la case courante est une instance de la classe Ennemi
        if (caseCourante instanceof Ennemi) {
            // Choix combat ou fuite
            do {
                System.out.println("Veux-tu combattre ou t'enfuir? C/E");
                // récupération input utilisateur c/e
                choice = sc.nextLine().toLowerCase();
                if (choice.equals("c")) {
                    // appel de la méthode interact pour combattre
                    caseCourante.interact(perso, plateau);
                } else if (choice.equals("e")) {
                    // test exception hors plateau < 0
                    try {
                        controle(perso.getPosition() - giveDice());
                        // appel méthode fuir pour reculer d'un nombre de case aléatoire
                        perso.fuir(giveDice());
                    } catch (PersonnageHorsPlateauException e) {
                        // si exception interceptée le perso va sur la case 0
                        perso.setPosition(0);
                        // afichage message d'erreur
                        System.out.println(e.getMessage());
                    }
                    // on réaffecte la position du joueur à la case courante
                    caseCourante = plateau.getCase(perso.getPosition());
                    // rappel de la mếthode à l'intérieur d'elle-même (récursivité) pour afficher infos case puis choix c ou e
                    this.decision(perso, caseCourante);
                } else {
                    // Si le choix ne correspond ni à c ni à e, afficher message d'erreur
                    System.out.println("Tu dois choisir entre C et E!");
                }
            // tant que le choix entre c ou n'est pas valide, boucler
            } while ((!choice.equals("c")) && (!choice.equals("e")));
        // Si la case courante n'est pas une instance d'Ennemi
        } else {
            // appel de la méthode interact
            caseCourante.interact(perso, plateau);
        }
    }

    /**
     * méthode qui boucle sur la méthode jouer_un_tour jusqu'à ce que le joueur ait gagné
     * @param menu de type Menu pour pouvoir appeler la méthode qui permet de choisir à nouveau le Menu entre jouer et quitter la partie
     * @param perso de type Perso pour utiliser ses accesseurs et mutateurs de position
     */
    public void play(Menu menu, Perso perso) {
        // appel méthode qui mélange aléatoirement les cases du plateau
        plateau.mix();
        do {
            // Délimitation graphique des cases
            System.out.println("-----------------------------------------------------");
            // si le perso a toujours des points de vie
            if (perso.getLife() > 0) {
                System.out.println("Appuie sur Entrée pour lancer le dé et avancer sur le plateau");
                // input Entrée pour marquer un arrêt entre chaque case
                sc.nextLine();
                // appel méthode jouer un tour
                jouer_un_tour(perso);
            } else {
                // Si le joueur n'a plus de points de vie, affichage message Game Over
                System.out.println("Tu as perdu le jeu!");
                // Arrêt du programme
                break;
            }
        // tant que la position du joueur est inférieure à la dernière case du plateau, boucler sur le code précédent
        } while (perso.getPosition() < plateauLength);
        // Si le joueur est sur la case 64
        if (perso.getPosition() == plateauLength) {
            // affichage message vaincoeur
            System.out.println("Case 64/64: Tu as gagné!");
            // affichage du choix entre quitter et créer un nouveau perso
            menu.chooseMenu(this);
        }
    }
}
