package com.company;
import java.util.Scanner;

public class Menu {
    public void display(){
        System.out.println("Create new perso");
        System.out.println("Quit game");
    }

    public void choose(Scanner input){
        System.out.println("Write '0' to quit or '1' to create a new perso");
        int response = input.nextInt();
        String clavier = input.nextLine();
        if (response == 0) {
            System.out.println("Bye bye");
            System.exit(0);
        } else if (response == 1){
            System.out.println("Please choose your perso: type Wizard or Warrior :");
            String perso = input.nextLine();
            if (perso.equals("Wizard")) {
                System.out.println("You chose to be a : " + perso);
                Wizard wizard = this.createWizard(input);
            }
            else if (perso.equals("Warrior")){
                System.out.println("You chose to be a : " + perso);
                Warrior warrior = this.createWarrior(input);
            }

        }
    }

    public Warrior createWarrior(Scanner input){
        System.out.println("Please enter your warrior name: ");
        String warName = input.nextLine();
        Warrior warrior = new Warrior(warName);
        return warrior;
    }

    public Wizard createWizard(Scanner input){
        System.out.println("Please enter your warrior name: ");
        String wizName = input.nextLine();
        Wizard wizard = new Wizard(wizName);
        return wizard;
    }
}