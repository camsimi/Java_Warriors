package com.company.personnages;
import com.company.weapons.Weapon;

public class Warrior extends Perso {
    private Weapon weapon;

    public Warrior() {
        super("Anonymous wizard", 5, 5);
    }

    public Warrior(String n){
        super(n, 5, 5);
    }

//    public Warrior(String n, int l,  int s){
//        super(n, l, s);
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

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", mon arme est une " + weapon;
    }
}