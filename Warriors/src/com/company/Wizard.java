package com.company;
import java.util.Scanner;

public class Wizard {
    private String name;
    private String image;
    private int life;
    private int strength;
    private int spell;
    private String weapon;

    public Wizard() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter your wizard name :");
        this.name = sc.nextLine();
        System.out.println("Your wizard name is : " + name);
    }

    public Wizard(String name){

    }

    public Wizard(String name, String image, int life, int strength){

    }

    public int getLife() {
        return life;
    }

    public String getName() {
        return name;
    }

    public String getImage() {
        return image;
    }

    public int getStrength() {
        return strength;
    }

    public int getSpell() {
        return spell;
    }

    public String getWeapon() {
        return weapon;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setLife(int life) {
        if ((life>=3) && (life<=6) ) {
            this.life = life;
        } else {
            System.out.println("You must enter a life inferior to 10.");
        }
    }

    public void setStrength(int strength) {
        if ( (strength>=8) && (strength<=15) ) {
            this.strength = strength;
        } else {
            System.out.println("You must enter a strength between 5 and 10.");
        }
    }

    public void setSpell(int spell) {
        this.spell = spell;
    }

    public void setWeapon(String weapon) {
        this.weapon = weapon;
    }
}