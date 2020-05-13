package com.company;
import java.util.Scanner;

public class Wizard {
    private String name;
    private int life;
    private int strength;
//    private int spell;
//    private String potion;

    public Wizard() {
        this.name = "Nina";
        this.life = 3;
        this.strength = 8;
    }

    public Wizard(String pName){
        this.name = pName;
        this.life = 3;
        this.strength = 8;
    }

    public Wizard(String pName, int pLife, int pStrength){
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

//    public String getImage() {
//        return image;
//    }

    public int getStrength() {
        return strength;
    }

//    public int getSpell() {
//        return spell;
//    }
//
//    public String getPotion() {
//        return potion;
//    }

    public void setName(String name) {
        this.name = name;
    }

//    public void setImage(String image) {
//        this.image = image;
//    }

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

//    public void setSpell(int spell) {
//        this.spell = spell;
//    }
//
//    public void setPotion(String pPotion) {
//        this.potion = pPotion;
//    }
}