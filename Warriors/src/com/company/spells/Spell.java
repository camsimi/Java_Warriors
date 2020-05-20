package com.company.spells;

import com.company.Case;
import com.company.personnages.Perso;
import com.company.personnages.Warrior;
import com.company.personnages.Wizard;

public abstract class Spell extends Case {
    protected int spellStrength;

    public Spell(){
    }

    public Spell(String sName, int sStrength, int num){
        super(sName, num);
        this.spellStrength = sStrength;
    }

    @Override
    public void interact(Perso perso) {
        if (perso instanceof Wizard){
            System.out.println("J'interagis avec Magicien");
        } else if (perso instanceof Warrior){
            System.out.println("j'interagis avec Warrior");
        } else {
            System.out.println("j'interagis avec Personne");
        }
    }

    public int getSpellStrength() {
        return spellStrength;
    }

    public void setSpellStrength(int spellStrength) {
        this.spellStrength = spellStrength;
    }

    public void addSpellStrength(Perso perso){
        perso.setStrength(perso.getStrength() + this.spellStrength);
    }
}
