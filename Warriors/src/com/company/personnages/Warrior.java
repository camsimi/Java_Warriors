package com.company.personnages;

import com.company.weapons.Weapon;

public class Warrior extends Perso {
    private Weapon weapon;

    public Warrior() {
        super("Anonymous wizard", 5, 5, 5, 10, 5, 10);
    }

    public Warrior(String n) {
        super(n, 5, 5, 5, 10, 5, 10);
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
                ", mon arme est une: " + weapon;
    }
}