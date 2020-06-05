package com.company.personnages;

import com.company.weapons.Weapon;

/**
 * Représente l'objet Warrior
 */
public class Warrior extends Perso {
    /**
     * attribut privé propre au guerrier, représente une arme (classe abstraite de type Weapon)
     */
    private Weapon weapon;

    /**
     * Permet de construire l'objet Warrior au moment de son instanciation
     * ne prend aucun paramètre et utilise le constructeur
     * qui prend un nom en paramètre pour instancier le nom par défaut
     */
    public Warrior() {
        this("Anonymous warrior");
    }


    /**
     * Permet de construire l'objet Warrior au moment de son instanciation.
     * Prend un paramètre qui représente le nom et utilise le constructeur parent
     * qui prend tous les attributs d'un personnage pour instancier un Warrior par défaut
     * @param n de type chaîne de caractère qui récupère le nom du Warrior
     */
    public Warrior(String n) {
        super(n, 5, 5, 5, 10, 5, 10);
    }

    /**
     * Récupère l'arme
     * @return objet de type Weapon
     */
    public Weapon getWeapon() {
        return weapon;
    }

    /**
     * Modifie l'arme
     * @param weapon de type Weapon
     */
    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    /**
     * Décrit l'objet Warrior en utilisant la méthode parente et en ajoutant la description de l'arme
     * @return une chaîne de caractère qui représente l'objet
     */
    @Override
    public String toString() {
        return super.toString() +
                ", mon arme est une " + weapon;
    }
}