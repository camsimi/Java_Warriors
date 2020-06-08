package com.company.enemies;

import com.company.board.EmptySquare;
import com.company.board.Square;
import com.company.heroes.Hero;
import com.company.board.Board;

/**
 * Construit un Ennemi qui hérite de la classe Case et
 * a de nouveaux attributs privés pour stocker les points de vie et de force
 */
public abstract class Enemy extends Square {
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
    public Enemy(String name, int life, int strength) {
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
                + ", il a " + getStrength() + " point(s) de force d'attaque et "
                + getLife() + " point(s) de vie.";
    }

    /**
     * Méthode qui réécrit la méthode parente interact pour combattre avec le personnage
     * @param hero de type Perso(wizard ou warrior)
     * @param board de type Plateau (ArrayList de Case)
     */
    @Override
    public void interact(Hero hero, Board board) {
        System.out.println(hero.getName() + ": Prête pour la bagarre " + this.getName() + " ?");
        System.out.println("Prends ça! " + hero.getStrength() + " point(s) de force d'attaque sur toi!");
        this.setLife(this.getLife() - hero.getStrength());
        System.out.println(this);
        if ((this.getStrength() > 0) && (this.getLife() > 0)) {
            System.out.println(this.getName() + ": Si tu le prends comme ça " + hero.getName() + ", je t'attaque avec " + this.getStrength() + " point(s) de force!");
            hero.setLife(hero.getLife() - this.getStrength());
        }
        if (this.getLife() <=0 ){
            board.setCase(hero.getPosition(), new EmptySquare());
            System.out.println("Case numéro " + hero.getPosition() +"/64 --> " + board.getCase(hero.getPosition()));
        }
    }
}
