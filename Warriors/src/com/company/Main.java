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
// Choisir entre les différentes options
        menu.choose(sc);
    }
}


