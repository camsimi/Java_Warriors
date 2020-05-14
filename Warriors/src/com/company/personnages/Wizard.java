package com.company.personnages;

public class Wizard extends Perso {
    private int spell;
    private String potion;

    public Wizard() {
        this.name = "Wizard Anonymous";
        this.life = 3;
        this.strength = 8;
    }

    public Wizard(String n){
        super(n);
        this.life = 3;
        this.strength = 8;
    }

    public Wizard(String n, int l, int s){
        super(n, l, s);
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

    public int getSpell() {
        return spell;
    }

    public String getPotion() {
        return potion;
    }

    public void setSpell(int spell) {
        this.spell = spell;
    }

    public void setPotion(String potion) {
        this.potion = potion;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", Spell: " + spell + '\n' +
                ", Potion: " + potion;
    }
}