package com.company.personnages;
import com.company.potions.Potion;

public abstract class Perso {
    private String name = "Perso Anonymous";
    private int strength = 0;
    private int life = 0;
    private Potion potion;

    public Perso(){
    }

    public Perso(String pName){
        this.name = pName;
    }

    public Perso(String pName, int pLife, int pStrength){
        this.name = pName;
        this.life = pLife;
        this.strength = pStrength;
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
        this.strength = strength;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public void setPotion(Potion potion) {
        this.potion = potion;
    }

    @Override
    public String toString() {
        return "Perso: \n" +
                "Je m'appelle " + name +
                ", j'ai " + strength + " points de force, " +
                life + " points de vie" +
                ", ma potion est : " + potion;
    }
}
