package com.company.weapons;
import com.company.Case;
import com.company.personnages.Perso;
import com.company.personnages.Warrior;
import com.company.personnages.Wizard;

public abstract class Weapon extends Case {
    protected int weaponStrength;

    public Weapon(){

    }

    public Weapon (String wName, int wStrength, int num){
        super(wName, num);
        this.weaponStrength = wStrength;
    }

    @Override
    public void interact(Perso perso) {
        if (perso instanceof Wizard){
            System.out.println("Oh une arme, c'est nul je ne peux pas la prendre, je suis un magicien!");
        }
    }

    public int getWeaponStrenght() {
        return weaponStrength;
    }

    public void setWeaponStrenght(int weaponStrenght) {
        this.weaponStrength = weaponStrenght;
    }

    public void addWeaponStrength(Perso perso){
        perso.setStrength(perso.getStrength() + this.weaponStrength);
    }
}
