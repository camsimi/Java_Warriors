package com.company;

import com.company.board.Board;
import com.company.board.Square;
import com.company.enemies.Enemy;
import com.company.heroes.Hero;
import com.company.heroes.Warrior;
import com.company.heroes.Wizard;

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
    Board board = new Board();
    // attribut qui stocke la longueur du plateau
    private final int boardLength = board.getBoardLength();
    // Instancie un nouveau Scanner pour récupérer les inputs
    Scanner sc = new Scanner(System.in);

    /**
     * Méthode qui permet de récupérer le type de personnage (wizard/warrior) avec un input utilisateur
     * @param menu de type Menu pour pouvoir accéder aux méthodes de l'instance menu comme quit()
     * @return chaîne de caractère: Wizard ou Warrior, le type de personnage choisi par l'utilisateur
     */
    public String chooseType(Menu menu) {
        String heroType = "";
        do {
            System.out.println("Choisi ton personnage: tape guerrier ou magicien.");
            heroType = sc.nextLine().toLowerCase();
            if ((heroType.equals("guerrier") || (heroType.equals("magicien")))) {
                System.out.println("Tu as choisi d'être un : " + heroType);
            } else if (heroType.equals("quit") || heroType.equals("quitter")) {
                menu.quit();
            } else {
                System.out.println("Tu dois choisir entre Guerrier et Magicien. \n Tape 'qutiter' pour quitter le jeu.");
            }
        } while ((!heroType.equals("guerrier")) && (!heroType.equals("magicien")));
        return heroType;
    }

    /**
     * Récupère le user input pour le nom du personnage
     * @return le nom du personnage sous la forme d'une chaîne de caractères
     */
    private String chooseName() {
        System.out.println("Entre le nom de ton personnage: ");
        return sc.nextLine();
    }

    /**
     * Nouveau perso (wizard ou warrior) instancé à partir des inputs utilisateurs (type et nom)
     * @param heroType wizard ou warrior de type chaîne de caractère
     * @param heroName nom du personnage de type chaîne de caractère
     * @return un personnage de type Perso (Wizard ou Warrior)
     */
    private Hero instanciatePerso(String heroType, String heroName) {
        Hero personnage;
        if (heroType.equals("guerrier")) {
            personnage = new Warrior(heroName);
        } else {
            personnage = new Wizard(heroName);
        }
        return personnage;
    }

    /**
     * Choix entre afficher les infos du personnage ou quitter le jeu
     * @param hero de type Hero pour accéder à ses infos et sa méthode toString
     * @param menu de type Menu pour accéder à sa méthode quit()
     */
    // on propose un choix à l'utilisateur entre voir les infos du perso ou quitter
    public void displayHero(Hero hero, Menu menu) {
        System.out.println("Tape 'oui' pour voir les infos de ton personnage.");
        String response = sc.nextLine().toLowerCase();
        if (response.equals("oui")) {
            System.out.println(hero.toString());
        } else if (response.equals("quit")) {
            menu.quit();
        }
    }

    /**
     * Création nouveau personnage en appelant la méthode instanciatePerso()
     * @param menu de type Menu
     * @param heroType de type chaîne de caractère
     * @return une personnage de type Hero
     */
    // on crée un perso en instanciant son type et avec le nom saisi en input
    public Hero createHero(Menu menu, String heroType) {
        // Choisir un nom au perso et le stocker dans une variable
        String heroName = this.chooseName();
        /*Créer un nouveau perso (instancier un Warrior/Wizard à partir de la classe Perso)
        avec en paramètre le type et le nom du perso */
        Hero hero = this.instanciatePerso(heroType, heroName);
        // Afficher les infos du perso en récupérant les objets perso et menu en paramètres.
        this.displayHero(hero, menu);
        // retourne un objet perso de type Perso
        return hero;
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
     * @throws HeroOutOfBoardException qui gère quand le perso sort du plateau (<0 et >64)
     */
    private void controle(int result) throws HeroOutOfBoardException {
        // Si le joueur sort du plateau (en-dessous de 0, et au-dessus de 64)
        if ((result > 64) || (result < 0))
            // Appeler l'exception
            throw new HeroOutOfBoardException();
    }

    /**
     * Méthode qui contient le déroulé d'un tour complet, lancer de dé, avancement du personnage, interaction avec les cases
     * @param hero de type Hero pour appeler ses méthodes qui permettent de récupérer et modifier la position du joueur,
     * d'afficher ses informations
     */
    private void play_a_round(Hero hero) {
        // lance le dé au hasard et stocke le résultat dans la variable dice
        int dice = this.giveDice();
        System.out.println("...**********.....");
        // affiche l'avancement en nombre de cases
        System.out.println("Avance de " + dice + " case(s).");
        // Représentation graphique de l'avancement du joueur
        System.out.println("...**********.....");
        // Test exception
        try {
            controle(hero.getPosition() + dice);
            // on additionne la position du joueur et le résultat du dé
            hero.setPosition(hero.getPosition() + dice);
        // capture exception
        } catch (HeroOutOfBoardException e) {
            // Si exception interceptée le joueur va sur la case 64
            hero.setPosition(boardLength);
            // on affiche le message d'erreur
            System.out.println(e.getMessage());
        }
        // Si le joueur n'a pas atteint la case 64
        if (hero.getPosition() != boardLength) {
            // récupération de la case courante avec la position du joueur
           Square currentSquare = board.getCase(hero.getPosition());
            // Interaction de la case avec le personnage
            decision(hero, currentSquare);
            // Affichage infos/attributs perso
            System.out.println(hero.toString());
        }
    }

    /**
     * Méthode qui permet au personnage de combattre ou de fuir en fonction du choix de l'utilisateur
     * @param hero de type Hero pour utiliser notamment sa méthode fuir()
     * @param currentSquare de type Case pour mettre à jour la case courante
     */
    private void decision(Hero hero, Square currentSquare) {
        // variable qui récupère une chaîne de caractère qui contient c (pour combattre) ou e (pour fuir)
        String fightOrLeaveChoice;
        // affichage du numéro de la case courante et de ses infos
        System.out.println("Case " + hero.getPosition() + "/64 " + currentSquare.toString());
        // Si la case courante est une instance de la classe Ennemi
        if (currentSquare instanceof Enemy) {
            // Choix combat ou fuite
            do {
                System.out.println("Veux-tu combattre ou t'enfuir? Tape C ou E.");
                // récupération input utilisateur c/e
                fightOrLeaveChoice = sc.nextLine().toLowerCase();
                if (fightOrLeaveChoice.equals("c")) {
                    // appel de la méthode interact pour combattre
                    currentSquare.interact(hero, board);
                } else if (fightOrLeaveChoice.equals("e")) {
                    // test exception hors plateau < 0
                    try {
                        controle(hero.getPosition() - giveDice());
                        // appel méthode fuir pour reculer d'un nombre de case aléatoire
                        hero.escape(giveDice());
                    } catch (HeroOutOfBoardException e) {
                        // si exception interceptée le perso va sur la case 0
                        hero.setPosition(0);
                        // afichage message d'erreur
                        System.out.println(e.getMessage());
                    }
                    // on réaffecte la position du joueur à la case courante
                    currentSquare = board.getCase(hero.getPosition());
                    // rappel de la mếthode à l'intérieur d'elle-même (récursivité) pour afficher infos case puis choix c ou e
                    this.decision(hero, currentSquare);
                } else {
                    // Si le choix ne correspond ni à c ni à e, afficher message d'erreur
                    System.out.println("Tu dois choisir entre C et E!");
                }
            // tant que le choix entre c ou n'est pas valide, boucler
            } while ((!fightOrLeaveChoice.equals("c")) && (!fightOrLeaveChoice.equals("e")));
        // Si la case courante n'est pas une instance d'Ennemi
        } else {
            // appel de la méthode interact
            currentSquare.interact(hero, board);
        }
    }

    /**
     * méthode qui boucle sur la méthode jouer_un_tour jusqu'à ce que le joueur ait gagné
     * @param menu de type Menu pour pouvoir appeler la méthode qui permet de choisir à nouveau le Menu entre jouer et quitter la partie
     * @param hero de type Hero pour utiliser ses accesseurs et mutateurs de position
     */
    public void play(Menu menu, Hero hero) {
        // appel méthode qui mélange aléatoirement les cases du plateau
        board.randomizeBoard();
        do {
            // Délimitation graphique des cases
            System.out.println("-----------------------------------------------------");
            // si le perso a toujours des points de vie
            if (hero.getLife() > 0) {
                System.out.println("Appuie sur Entrée pour lancer le dé et avancer sur le plateau");
                // input Entrée pour marquer un arrêt entre chaque case
                sc.nextLine();
                // appel méthode jouer un tour
                play_a_round(hero);
            } else {
                // Si le joueur n'a plus de points de vie, affichage message Game Over
                System.out.println("Tu as perdu le jeu!");
                // Arrêt du programme
                break;
            }
        // tant que la position du joueur est inférieure à la dernière case du plateau, boucler sur le code précédent
        } while (hero.getPosition() < boardLength);
        // Si le joueur est sur la case 64
        if (hero.getPosition() == boardLength) {
            // affichage message vaincoeur
            System.out.println("Case 64/64: Tu as gagné!");
            // affichage du choix entre quitter et créer un nouveau personnage
            menu.chooseMenu(this);
        }
    }
}
