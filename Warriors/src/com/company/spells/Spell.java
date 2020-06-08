package com.company.spells;

import com.company.board.Board;
import com.company.heroes.Hero;
import com.company.board.Square;
import com.company.heroes.Warrior;
import com.company.heroes.Wizard;

public abstract class Spell extends Square {
    protected int spellStrength;
    public Spell(){}
    public Spell(String sName, int sStrength){
        super(sName);
        this.spellStrength = sStrength;
    }
    @Override
    public void interact(Hero hero, Board board) {
        if (hero instanceof Warrior){
            System.out.println("Oh un sort, c'est nul je ne peux pas le prendre, je suis une guerrière!");
        }
        else if (hero instanceof Wizard){
            System.out.println("Youpi, j'ai maintenant un sort " + getName() + ", " + this.getSpellStrength()
            + " points de force supplémentaires!");
            ((Wizard) hero).setSpell(this);
            this.addSpellStrength(hero);
        }
    }
    public int getSpellStrength() {
        return spellStrength;
    }
    public void addSpellStrength(Hero hero){
        hero.setStrength(hero.getStrength() + this.spellStrength);
    }
}
