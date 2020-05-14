package com.company.personnages;

public class Warrior extends Perso {
    private int spell;
    private String weapon;

    public Warrior() {
        this.name ="Warrior Anonymous";
        this.life = 5;
        this.strength = 5;
    }

    public Warrior(String n){
        super(n);
        this.life = 5;
        this.strength = 5;
    }

    public Warrior(String n, int l,  int s){
        super(n, l, s);
    }

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

    public int getSpell() {
        return spell;
    }

    public String getWeapon() {
        return weapon;
    }

    public void setSpell(int spell) {
        this.spell = spell;
    }

    public void setWeapon(String weapon) {
        this.weapon = weapon;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", Spell: " + spell +
                ", Weapon: " + weapon;
    }
}