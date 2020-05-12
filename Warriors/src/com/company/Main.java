package com.company;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Menu menu = new Menu();
        menu.display();
// Choisir
        System.out.println("Write '0' to quit or '1' to create a new perso");
        int response = sc.nextInt();
        if (response == 0) {
//            String quit = sc.nextLine();
            System.out.println("Bye bye");
        } else if (response == 1){
            String perso = sc.nextLine();
            Warrior warrior = menu.createWarrior(sc);
        }
    }
}


