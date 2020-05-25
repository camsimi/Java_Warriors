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
        perso.setPotion(this);
        perso.setLife(perso.getLife() + this.getPotionLife());
        System.out.println("Chouette une potion de vie " + getName() + " , " + getPotionLife() + " points de vie supplémentaires!");
    }


    public int getPotionLife() {
        return potionLife;
    }

    public void setPotionLife(int potionLife) {
        this.potionLife = potionLife;
    }

    public void addLife(Perso perso){
        perso.setLife(perso.getLife() + this.potionLife);
    }
}
