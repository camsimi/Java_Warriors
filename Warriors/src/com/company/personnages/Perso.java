package com.company.personnages;
import com.company.potions.Potion;

public abstract class Perso {
    private String name = "Perso Anonymous";
    private int strength;
    private int life;
    private int minStrength;
    private int maxStrength;
    private int minLife;
    private int maxLife;
    private Potion potion;

    public Perso(String pName, int pLife, int pStrength, int minStrength, int maxStrength, int minLife, int maxLife){
        this.name = pName;
        this.life = pLife;
        this.strength = pStrength;
        this.minStrength = minStrength;
        this.maxStrength = maxStrength;
        this.minLife = minLife;
        this.maxLife = maxLife;
    }

    public String getName() {
        return name;
    }

    public int getStrength() {
        return strength;
    }

    public int getLife() {
        return life;
    }

    public Potion getPotion() {
        return potion;
    }

    public void setName(String name) {
        if (name!= null){
            this.name = name;
        }
    }

    public void setStrength(int strength) {
        if ( (strength >=this.getMinStrength()) && (strength <=this.getMaxStrength()) ) {
            this.strength = strength;
        } else if (strength > this.getMaxStrength()){
            System.out.println("Your maximum strength is " + this.getMaxStrength());
            this.strength = this.getMaxStrength();
        }
    }

    public void setLife(int life) {
        if ((life>=this.getMinLife()) && (life<=this.getMaxLife()) ) {
            this.life = life;
        } else if (life > this.getMaxLife()){
            System.out.println("Your maximum life is " + this.getMaxLife());
            this.life = this.getMaxLife();
        }
    }

    public void setPotion(Potion potion) {
        this.potion = potion;
    }

    public int getMinStrength() {
        return minStrength;
    }

    public int getMaxStrength() {
        return maxStrength;
    }

    public int getMinLife() {
        return minLife;
    }

    public int getMaxLife() {
        return maxLife;
    }

    @Override
    public String toString() {
        return "Je m'appelle " + name +
                ", j'ai " + strength + " points de force, " +
                life + " points de vie" +
                ", ma potion est une " + potion;
    }
}
