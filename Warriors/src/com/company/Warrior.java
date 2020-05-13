package com.company;
import java.util.Scanner;

public class Warrior {
    private String name;
//    private String image;
    private int life;
    private int strength;
//    private int spell;
//    private String weapon;

    public Warrior() {
        this.name ="Bob";
        this.life = 5;
        this.strength = 5;
    }

    public Warrior(String pName) {
        this.name = pName;
        this.life = 5;
        this.strength = 5;
    }

    public Warrior(String pName, int pLife, int pStrength){
        this.name = pName;
        this.life = pLife;
        this.strength = pStrength;
    }

    public int getLife() {
        return life;
    }

    public String getName() {
        return name;
    }

    public int getStrength() {
        return strength;
    }

//    public String getImage() {
//        return image;
//    }
//
//    public int getSpell() {
//        return spell;
//    }
//
//    public String getWeapon() {
//        return weapon;
//    }

    public void setName(String name) {
//        Scanner sc = new Scanner(System.in);
//        System.out.println("Please enter your warrior name :");
//        this.name = sc.nextLine();
//        System.out.println("Your warrior name is : " + name);
        this.name = name;
    }

//    public void setImage(String image) {
//        this.image = image;
//    }

    public void setLife(int life) {
        if (life<=10) {
            this.life = life;
        } else {
            System.out.println("You must enter a life inferior to 10.");
        }
    }

    public void setStrength(int strength) {
        if ( (strength>=5) && (strength<=10) ) {
            this.strength = strength;
        } else {
            System.out.println("You must enter a strength between 5 and 10.");
        }
    }

//    public void setSpell(int spell) {
//        this.spell = spell;
//    }
//
//    public void setWeapon(String weapon) {
//        this.weapon = weapon;
//    }
}