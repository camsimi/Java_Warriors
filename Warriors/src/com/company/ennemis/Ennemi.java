package com.company.ennemis;

import com.company.Case;
import com.company.CaseVide;
import com.company.Plateau;
import com.company.personnages.Perso;

import java.util.ArrayList;

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
        if (life <= 0) {
            this.life = 0;
            System.out.println("Aaaaah je meurs, soit maudite!");
        }
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
                + ", il a " + getStrength() + " en force d'attaque et "
                + getLife() + " point(s) de vie.";
    }


    public void interact(Perso perso, Plateau plateau) {
        System.out.println(perso.getName() + ": Prête pour la bagarre " + this.getName() + " ?");
        System.out.println("Prends ça! " + perso.getStrength() + " point(s) de force d'attaque sur toi!");
        this.setLife(this.getLife() - perso.getStrength());
        System.out.println(this);
        if ((this.getStrength() > 0) && (this.getLife() > 0)) {
            System.out.println(this.getName() + ": Si tu le prends comme ça " + perso.getName() + ", je t'attaque avec " + this.getStrength() + " point(s) de force!");
            perso.setLife(perso.getLife() - this.getStrength());
        }
        if (this.getLife() <=0 ){
            plateau.setCase(this.getNum(), new CaseVide(this.getNum()));
            System.out.println("Case numéro " + this.getNum() +"/64 --> " + plateau.getCase(this.getNum()));
        }
    }
}
