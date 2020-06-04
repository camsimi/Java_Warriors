package com.company.potions;

import com.company.plateau.Case;
import com.company.plateau.Plateau;
import com.company.personnages.Perso;

public abstract class Potion extends Case{
    protected int potionLife;

    public Potion(){
    }

    public Potion(String pName, int pLife){
        super(pName);
        this.potionLife = pLife;
    }

    @Override
    public void interact(Perso perso, Plateau plateau){
        System.out.println("Chouette une potion de vie " + getName() + " , " + getPotionLife() + " points de vie supplémentaires!");
        perso.setPotion(this);
        addLife(perso);
    }

    public int getPotionLife() {
        return potionLife;
    }

    public void addLife(Perso perso){
        perso.setLife(perso.getLife() + this.potionLife);
    }
}
