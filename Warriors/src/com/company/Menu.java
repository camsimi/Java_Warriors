package com.company;
import java.util.Scanner;

public class Menu {
public Scanner sc = new Scanner(System.in);

    public String chooseMenu(Game game) {
        String response;
        String heroType = "";
        do {
            System.out.println("Tape '0' pour quitter ou '1' pour créer un nouveau personnage:");
            response = sc.nextLine();
            if (response.equals("0")) {
                System.out.println("Bye bye");
                this.quit();
            } else if (response.equals("1")) {
                heroType = game.chooseType(this);
            } else {
                System.out.println("Tape 0 ou 1");
            }
        }while (!response.equals("1"));
        return heroType;
    }

    public void quit(){
        System.exit(0);
    }
}