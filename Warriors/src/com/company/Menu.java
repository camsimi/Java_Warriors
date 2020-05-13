package com.company;
import java.util.Scanner;

public class Menu {
    public void display(){
        System.out.println("Create new perso");
        System.out.println("Quit game");
    }

    public String chooseMenu(Scanner input){
        String perso = "";
        System.out.println("Write '0' to quit or '1' to create a new perso:");
        int response = input.nextInt();
        String clavier = input.nextLine();
        if (response == 0) {
            System.out.println("Bye bye");
            this.quit();
        } else if (response == 1){
            do {
                System.out.println("Please choose your perso: type Wizard or Warrior :");
                perso = input.nextLine();
                if (perso.equals("Wizard")) {
                    System.out.println("You chose to be a : " + perso);
                } else if (perso.equals("Warrior")) {
                    System.out.println("You chose to be a : " + perso);
                } else if (perso.equals("quit") || perso.equals("quitter") || perso.equals("Quit")) {
                    this.quit();
                } else {
                    System.out.println("You have to choose between Wizard and Warrior. \n Type 'quit' to quit the game. ");
                }
            }while ((!perso.equals("Wizard")) && (!perso.equals("Warrior")));
        }
        return perso;
    }

    public String chooseName(Scanner input){
        System.out.println("Please enter your perso name: ");
        String persoName = input.nextLine();
        return persoName;
    }

    public Perso createPerso(Scanner input, String persoType, String persoName){
        Perso personnage;
        if (persoType.equals("Warrior")) {
           personnage = new Warrior(persoName);
        }
        else {
            personnage = new Wizard(persoName);
        }
        return personnage;
    }

    public void displayPerso(Perso perso, Scanner input){
        System.out.println("If you want to see your perso informations, press 'y'");
        String response = input.nextLine().toLowerCase();
        if (response.equals("y")) {
//            if (perso instanceof Wizard) {
//            System.out.println(((Wizard) perso).getName() + ((Wizard) perso).getLife()
//            + ((Wizard) perso).getStrength());
                System.out.println(perso);
//            } else if (perso instanceof Warrior) {
//            System.out.println(((Warrior) perso).getName() + ((Warrior) perso).getLife()
//                    + ((Warrior) perso).getStrength());
//                System.out.println(perso);
//            }
        }
        else if (response.equals("quit")){
            this.quit();
        }
    }

    public void play() {
        int player = 1;
        int plateau = 64;
        int dice;
    }

    public void quit(){
        System.exit(0);
    }
}