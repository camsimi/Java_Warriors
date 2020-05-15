package com.company.weapons;
import com.company.personnages.Perso;

public abstract class Weapon {
    protected int weaponStrenght;

    public Weapon(){
    }

    public Weapon (int wStrength){
        this.weaponStrenght = wStrength;
    }

    public int getWeaponStrenght() {
        return weaponStrenght;
    }

    public void setWeaponStrenght(int weaponStrenght) {
        this.weaponStrenght = weaponStrenght;
    }

    public void addWeaponStrenght(Perso perso){
        perso.setStrength(perso.getStrength() + this.weaponStrenght);
    }
}
