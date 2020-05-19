package com.company.weapons;
import com.company.personnages.Perso;

public abstract class Weapon {
    protected String name;
    protected int weaponStrenght;

    public Weapon(){
    }

    public Weapon (int wStrength, String wName){
        this.name = wName;
        this.weaponStrenght = wStrength;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
