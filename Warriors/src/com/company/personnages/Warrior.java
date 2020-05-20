package com.company.personnages;

import com.company.weapons.Weapon;

public class Warrior extends Perso {
    private Weapon weapon;

    public Warrior() {
        super("Anonymous wizard", 5, 5);
    }

    public Warrior(String n) {
        super(n, 5, 5);
    }

    public void setLife(int life) {
        if (life <= 10) {
            setLife(life);
        } else {
            System.out.println("You must enter a life inferior to 10.");
        }
    }

    public void setStrength(int strength) {
        if ((strength >= 5) && (strength <= 10)) {
            super.setStrength(strength);
        } else if (strength > 10) {
            super.setStrength(10);
            System.out.println("You can't have a strength superior to 10.");
        }
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public String getWeaponName() {
        return weapon.getName();
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", mon arme est une: " + weapon;
    }
}