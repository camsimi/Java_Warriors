package com.company.spells;

import com.company.personnages.Perso;

public abstract class Spell {

    protected int spellStrength;

    public Spell(){

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
