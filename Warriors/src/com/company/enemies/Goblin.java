package com.company.enemies;

/**
 * Représente un Gobelin qui hérite de la classe Ennemi qui hérite elle-même de la classe Case
 */
public class Goblin extends Enemy {

    /**
     * Constructeur sans paramètre qui utilise le constructeur parent avec trois paramètres pour
     * définir le nom, les points de vie et de force
     */
    public Goblin(){
        super("Gobelin", 6, 1);
    }
}
