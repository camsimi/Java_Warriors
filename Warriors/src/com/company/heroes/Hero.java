package com.company.heroes;

import com.company.potions.Potion;

/**
 * Représente un personnage type par défaut avec les attributs privés suivants:
 * <ul>
 *     <li>Le nom de type chaîne de caractère</li>
 *     <li>La force d'attaque de type entier</li>
 *     <li>Les points de vie de type entier</li>
 *     <li>Les points de vie minimum et maximum de type entier</li>
 *     <li>Les forces d'attaque minimum et maximum de type entier</li>
 *     <li>La potion de type Potion</li>
 *     <li>La position du joueur sur le plateau de type entier</li>
 * </ul>
 */
public abstract class Hero {
    private String name;
    private int strength;
    private int life;
    private final int minStrength;
    private final int maxStrength;
    private final int minLife;
    private final int maxLife;
    private Potion potion;
    private int posPlayer;

    /**
     * Permet de construire un personnage par défaut avec tous les attributs définis
     *
     * @param pName       de type chaîne de caractère
     * @param pLife       de type entier
     * @param pStrength   de type entier
     * @param minStrength de type entier
     * @param maxStrength de type entier
     * @param minLife     de type entier
     * @param maxLife     de type entier
     */
    public Hero(String pName, int pLife, int pStrength, int minStrength, int maxStrength, int minLife, int maxLife) {
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
        if (name != null) {
            this.name = name;
        }
    }

    /**
     * Mutateur qui permet de définir des points de force passés en paramètre et
     * en prenant en compte les points de force minimum et maximum grâce aux attributs correspondants
     *
     * @param strength de type entier
     */
    public void setStrength(int strength) {
        if ((strength >= this.getMinStrength()) && (strength <= this.getMaxStrength())) {
            this.strength = strength;
        } else if (strength > this.getMaxStrength()) {
            System.out.println("Tu ne peux pas dépasser " + this.getMaxStrength() + " points de force d'attaque.");
            this.strength = this.getMaxStrength();
        }
    }

    /**
     * Mutateur qui permet de définir des points de vie passés en paramètre et
     * en prenant en compte les points de vie minimum et maximum grâce aux attributs correspondants
     *
     * @param life de type entier
     */
    public void setLife(int life) {
        if (life <= this.getMaxLife() && (life > 0)) {
            this.life = life;
        } else if (life > this.getMaxLife()) {
            System.out.println("Tu ne peux pas dépasser " + this.getMaxLife() + " points de vie.");
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

    /**
     * Permet au personnage de fuir face à un ennemi
     * Sa position est redéfinie en fonction de l'entier passé en paramètre
     * @param random de type entier
     */
    public void escape(int random) {
        int newPosition = getPosition() - random;
        setPosition(newPosition);
        System.out.println("...**********.....");
        System.out.println("Je m'enfuis et je recule de " + random + " case(s).");
        System.out.println("...**********.....");
    }

    /**
     * Décrit l'objet Perso
     * @return une chaîne de caractère qui représente l'objet
     */
    @Override
    public String toString() {
        if (potion != null) {
            return "Je m'appelle " + name +
                    ", j'ai " + strength + " point(s) de force, " +
                    life + " point(s) de vie" +
                    ", ma potion est une " + potion;
        }
        else {
            return "Je m'appelle " + name +
                    ", j'ai " + strength + " point(s) de force, " +
                    life + " point(s) de vie";
        }
    }
}
