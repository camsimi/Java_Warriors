package com.company.ennemis;

import com.company.plateau.Case;
import com.company.plateau.CaseVide;
import com.company.plateau.Plateau;
import com.company.personnages.Perso;

/**
 * Construit un Ennemi qui hérite de la classe Case et
 * a de nouveaux attributs privés pour stocker les points de vie et de force
 */
public abstract class Ennemi extends Case{
    /**
     * attribut privé de type entier qui stocke les points vie
     */
    private int life;
    /**
     * attribut privé de type entier qui stocke les points de force d'attaque
     */
    private int strength;

    /**
     * Constructeur qui prend trois paramètres pour enregistrer le nom, les points de vie et de force
     * @param name de type chaîne de caractère
     * @param life de type entier
     * @param strength de type entier
     */
    public Ennemi(String name, int life, int strength) {
        super(name);
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

    /**
     * Réécrit la méthode toString en ajoutant la description des points de vie et de force à la méthode parente
     * @return une chaîne de caractère qui représente l'objet
     */
    @Override
    public String toString(){
        return super.toString()
                + ", il a " + getStrength() + " en force d'attaque et "
                + getLife() + " point(s) de vie.";
    }

    /**
     * Méthode qui réécrit la méthode parente interact pour combattre avec le personnage
     * @param perso de type Perso(wizard ou warrior)
     * @param plateau de type Plateau (ArrayList de Case)
     */
    @Override
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
            plateau.setCase(perso.getPosition(), new CaseVide());
            System.out.println("Case numéro " + perso.getPosition() +"/64 --> " + plateau.getCase(perso.getPosition()));
        }
    }
}
