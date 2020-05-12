package com.company;
import java.util.Scanner;

public class Menu {

    public static void main (String[] args) {

    }

    public void display(){
        System.out.println("Create new perso");
        System.out.println("Quit game");
    }



    public Warrior createWarrior(Scanner input){
        System.out.println("Please enter your warrior name: ");
        String warName = input.nextLine();
        Warrior warrior = new Warrior(warName);
        return warrior;
    }
}