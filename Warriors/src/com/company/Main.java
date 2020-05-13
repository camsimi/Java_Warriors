package com.company;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
// Instancie un nouveau Scanner pour récupérer les inputs
        Scanner sc = new Scanner(System.in);
// Instancie un nouveau menu
        Menu menu = new Menu();
// Afficher le choix du menu
        menu.display();
// Choisir entre les différentes options et stocker le retour Wizard/Warrior dans une variable
        String persoType = menu.chooseMenu(sc);
// Choisir un nom au perso et le stocker dans une variable
        String persoName = menu.chooseName(sc);
// Créer un nouveau perso (instancier un Warrior/Wizard à partir de la classe Perso)
// avec en paramètre le Scanner, le type et le nom du perso
        Perso perso = menu.createPerso(sc, persoType, persoName);
// Afficher les infos du perso en récupérant l'objet perso et le Scanner en paramètres.
        menu.displayPerso(perso, sc);
// Lancer la partie
        menu.play(sc);
    }
}


