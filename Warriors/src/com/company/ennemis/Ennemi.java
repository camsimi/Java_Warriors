package com.company.ennemis;

import com.company.Case;
import com.company.personnages.Perso;
import com.company.personnages.Warrior;
import com.company.personnages.Wizard;

public abstract class Ennemi extends Case {
    private int life;
    private int strength;

    public Ennemi(String name, int life, int strength, int num) {
        super(name, num);
        this.life = life;
        this.strength = strength;
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    @Override
    public String toString(){
        return super.toString()
                + ", il a " + getLife() + " points de vie et "
                + getStrength() + " en force d'attaque.";
    }

    @Override
    public void interact(Perso perso) {
        if (perso instanceof Wizard) {
            System.out.println("J'interagis avec un Magicien");
        } else if (perso instanceof Warrior) {
            System.out.println("J'interagis avec un Guerrier");
        } else {
            System.out.println("J'interagis avec un personnage original");
        }
    }
}
