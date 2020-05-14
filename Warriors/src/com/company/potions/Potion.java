package com.company.potions;

import com.company.personnages.Perso;

public abstract class Potion {
    protected int potionLife;

    public Potion(){

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
