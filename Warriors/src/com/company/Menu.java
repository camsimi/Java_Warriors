package com.company;
import com.company.personnages.Perso;
import com.company.personnages.Warrior;
import com.company.personnages.Wizard;
import java.util.Scanner;

public class Menu {

    public void display(){
        System.out.println("Create new perso");
        System.out.println("Quit game");
    }

    public String chooseMenu(Scanner input) {
        String response;
        String persoType = "";
        do {
            System.out.println("Write '0' to quit or '1' to create a new perso:");
            response = input.nextLine();
            if (response.equals("0")) {
                System.out.println("Bye bye");
                this.quit();
            } else if (response.equals("1")) {
                persoType = this.chooseType(input);
            } else {
                System.out.println("You should type 0 or 1");
            }
        }while (!response.equals("1"));
        return persoType;
    }

    public String chooseType(Scanner input){
        String persoType= "";
            do {
                System.out.println("Please choose your persoType: type Wizard or Warrior :");
                persoType = input.nextLine().toLowerCase();
                if (persoType.equals("wizard")) {
                    System.out.println("You chose to be a : " + persoType);
                } else if (persoType.equals("warrior")) {
                    System.out.println("You chose to be a : " + persoType);
                } else if (persoType.equals("quit") || persoType.equals("quitter")) {
                    this.quit();
                } else {
                    System.out.println("You have to choose between Wizard and Warrior. \n Type 'quit' to quit the game. ");
                }
            }while ((!persoType.equals("wizard")) && (!persoType.equals("warrior")));
        return persoType;
    }

    public String chooseName(Scanner input){
        System.out.println("Please enter your perso name: ");
        return input.nextLine();
    }

    public Perso createPerso(String persoType, String persoName){
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
                System.out.println(perso.toString());
        }
        else if (response.equals("quit")){
            this.quit();
        }
    }

    public int giveDice(int min, int max)
    {
        return (int) Math.floor(Math.random() * (max - min + 1)) + min;
    }

    public void play(Scanner input) {
        int player = 1;
        int plateau = 64;
        int tour = 0;
        int dice = 0;

        do {
            tour = tour + 1;
            dice = this.giveDice(1, 6);
            if (dice + player > plateau) {
                player = plateau;
            } else {
                player += dice;
            }
            System.out.println("Le joueur est sur la case " + player + "/64");
            if (player == plateau) {
                System.out.println("Tu as gagné!");
                this.chooseMenu(input);
            }
        } while (player<plateau);
    }

    public void quit(){
        System.exit(0);
    }
}