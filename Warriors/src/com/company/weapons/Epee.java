package com.company.weapons;

import com.company.personnages.Perso;
import com.company.personnages.Warrior;
import com.company.personnages.Wizard;

public class Epee extends Weapon {
    public Epee(int num) {
        super("Epée", 5, num);
    }

    @Override
    public void interact(Perso perso) {
        super.interact(perso);
        if (perso instanceof Warrior){
            ((Warrior) perso).setWeapon(this);
            super.addWeaponStrength(perso);
            System.out.println("Youpi, je suis maintenant armée d'une épée!");
        }
    }
}
