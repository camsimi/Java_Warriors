package com.company.spells;

import com.company.Case;
import com.company.Interact;
import com.company.Plateau;
import com.company.personnages.Perso;
import com.company.personnages.Warrior;
import com.company.personnages.Wizard;

public abstract class Spell extends Case {
    protected int spellStrength;

    public Spell(){
    }

    public Spell(String sName, int sStrength){
        super(sName);
        this.spellStrength = sStrength;
    }

    @Override
    public void interact(Perso perso, Plateau plateau) {
        if (perso instanceof Warrior){
            System.out.println("Oh un sort, c'est nul je ne peux pas le prendre, je suis une guerrière!");
        }
        else if (perso instanceof Wizard){
            System.out.println("Youpi, j'ai maintenant un sort " + getName() + ", " + this.getSpellStrength() + " points de force supplémentaires!");
            ((Wizard) perso).setSpell(this);
            this.addSpellStrength(perso);
        }
    }

    public int getSpellStrength() {
        return spellStrength;
    }

    public void addSpellStrength(Perso perso){

        perso.setStrength(perso.getStrength() + this.spellStrength);
    }
}
