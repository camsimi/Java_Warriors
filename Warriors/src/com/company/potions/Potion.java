package com.company.potions;

import com.company.Case;
import com.company.personnages.Perso;
import com.company.personnages.Warrior;
import com.company.personnages.Wizard;

public abstract class Potion extends Case {
    protected int potionLife;

    public Potion(){
    }

    public Potion(String pName, int pLife, int num){
        super(pName, num);
        this.potionLife = pLife;
    }

    public void interact(Perso perso){
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
