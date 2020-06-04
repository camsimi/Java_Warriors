package com.company.weapons;
import com.company.plateau.Case;
import com.company.plateau.Plateau;
import com.company.personnages.Perso;
import com.company.personnages.Warrior;
import com.company.personnages.Wizard;

public abstract class Weapon extends Case {
    protected int weaponStrength;

    public Weapon(){
    }

    public Weapon (String wName, int wStrength){
        super(wName);
        this.weaponStrength = wStrength;
    }

    @Override
    public void interact(Perso perso, Plateau plateau) {
        if (perso instanceof Wizard){
            System.out.println("Oh une arme, c'est nul je ne peux pas la prendre, je suis une magicienne!");
        }
        else if (perso instanceof Warrior){
            System.out.println("Youpi, je suis maintenant armée d'une " + getName() + ", " + getWeaponStrength() + " points de force supplémetaires!");
            ((Warrior) perso).setWeapon(this);
            addWeaponStrength(perso);
        }
    }

    public int getWeaponStrength() {
        return weaponStrength;
    }

    public void addWeaponStrength(Perso perso){
        perso.setStrength(perso.getStrength() + this.weaponStrength);
    }
}
