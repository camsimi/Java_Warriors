package com.company.weapons;

import com.company.personnages.Perso;
import com.company.personnages.Warrior;
import com.company.personnages.Wizard;

public class Massue extends Weapon {

    public Massue(){
    }
    public Massue(int num) {
        super("Massue", 3, num);
    }

    @Override
    public void interact(Perso perso) {
        super.interact(perso);
        if (perso instanceof Warrior){
            ((Warrior) perso).setWeapon(this);
            super.addWeaponStrength(perso);
            System.out.println("Youpi, je suis maintenant armée d'une massue!");
        }
    }
}
