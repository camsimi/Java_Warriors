package com.company.personnages;
import com.company.potions.Potion;

public abstract class Perso {
    protected String name = "Perso Anonymous";
    protected int strength = 0;
    protected int life = 0;
    private Potion potion;

    protected Perso(){
    }

    protected Perso(String pName){
        this.name = pName;
    }

    protected Perso(String pName, int pLife, int pStrength){
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
        this.name = name;
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
                "Name='" + name + '\'' +
                ", Strength=" + strength +
                ", Life=" + life +
                ", Potion= " + potion;
    }
}
