package com.company.potions;

import com.company.board.Square;
import com.company.heroes.Hero;
import com.company.board.Board;

public abstract class Potion extends Square {
    protected int potionLife;

    public Potion(){
    }

    public Potion(String pName, int pLife){
        super(pName);
        this.potionLife = pLife;
    }

    @Override
    public void interact(Hero hero, Board board){
        System.out.println("Chouette une potion de vie " + getName() + ", " + getPotionLife() + " points de vie supplémentaires!");
        hero.setPotion(this);
        addLife(hero);
    }

    public int getPotionLife() {
        return potionLife;
    }

    public void addLife(Hero hero){
        hero.setLife(hero.getLife() + this.potionLife);
    }
}
