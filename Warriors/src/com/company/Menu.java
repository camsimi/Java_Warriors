package com.company;
import java.util.Scanner;

public class Menu {
public Scanner sc = new Scanner(System.in);

    public void display(){
        System.out.println("Create new perso");
        System.out.println("Quit game");
    }

    public String chooseMenu(Game game) {
        String response;
        String persoType = "";
        do {
            System.out.println("Write '0' to quit or '1' to create a new perso:");
            response = sc.nextLine();
            if (response.equals("0")) {
                System.out.println("Bye bye");
                this.quit();
            } else if (response.equals("1")) {
                persoType = game.chooseType(this);
            } else {
                System.out.println("You should type 0 or 1");
            }
        }while (!response.equals("1"));
        return persoType;
    }

    public void quit(){
        System.exit(0);
    }
}