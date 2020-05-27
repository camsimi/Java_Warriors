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
    int posPlayer;

    public Perso(String pName, int pLife, int pStrength, int minStrength, int maxStrength, int minLife, int maxLife){
        this.name = pName;
        this.life = pLife;
        this.strength = pStrength;
        this.minStrength = minStrength;
        this.maxStrength = maxStrength;
        this.minLife = minLife;
        this.maxLife = maxLife;
        this.posPlayer = 0;
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
        if (life<=this.getMaxLife() && (life > 0)) {
            this.life = life;
        } else if (life > this.getMaxLife()){
            System.out.println("Your maximum life is " + this.getMaxLife());
            this.life = this.getMaxLife();
        }
        if (life <= 0) {
            this.life = 0;
            System.out.println("Aaaaah c'est la fin pour moi!");
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

    public int getPosition() {
        return posPlayer;
    }

    public void setPosition(int posPlayer) {
        this.posPlayer = posPlayer;
    }

    public void fuir(int random){
        int newPosition = getPosition() - random;
        setPosition(newPosition);
        System.out.println("Je m'enfuis et je recule de " + random + " case(s).");
        System.out.println("...**********.....");
    }

    @Override
    public String toString() {
        return "Je m'appelle " + name +
                ", j'ai " + strength + " point(s) de force, " +
                life + " point(s) de vie" +
                ", ma potion est une " + potion;
    }
}
