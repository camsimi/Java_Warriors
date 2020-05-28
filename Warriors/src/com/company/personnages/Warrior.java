package com.company.personnages;

import com.company.weapons.Weapon;

public class Warrior extends Perso {
    private Weapon weapon;

    /**
     * Constructeur de Warrior qui ne prend aucun paramètre et utilise le constructeur
     * qui prend le nom en paramètre pour instancier le nom par défaut
     */
    public Warrior() {
        this("Anonymous warrior");
    }

    /**
     * Constructeur de Warrior qui prend un paramètre n
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
     * Décrit l'objet Weapon
     * @return une chaîne de caractère qui représente l'objet
     */
    @Override
    public String toString() {
        return super.toString() +
                ", mon arme est une " + weapon;
    }
}