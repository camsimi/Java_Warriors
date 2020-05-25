package com.company.spells;

import com.company.personnages.Perso;
import com.company.personnages.Wizard;

public class Fire extends Spell{

    public Fire(int num){
        super("Fire", 7, num);
    }

    @Override
    public void interact(Perso perso) {
        super.interact(perso);
        if (perso instanceof Wizard){
            ((Wizard) perso).setSpell(this);
            super.addSpellStrength(perso);
            System.out.println("Youpi, j'ai maintenant un sort boule de feu!");
        }
    }
}
