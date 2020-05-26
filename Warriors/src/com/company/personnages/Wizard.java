package com.company.personnages;
import com.company.spells.Spell;

public class Wizard extends Perso {
    private Spell spell;

    public Wizard() {
        this("Anonymous wizard");
    }

    public Wizard(String n){
        super(n, 3, 8, 8, 15, 3, 6);
    }

    public Spell getSpell() {
        return spell;
    }

    public void setSpell(Spell spell) {
        this.spell = spell;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", mon sort est un " + spell;
    }
}