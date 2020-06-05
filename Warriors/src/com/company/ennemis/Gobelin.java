package com.company.ennemis;

/**
 * Représente un Gobelin qui hérite de la classe Ennemi qui hérite elle-même de la classe Case
 */
public class Gobelin extends Ennemi{

    /**
     * Constructeur sans paramètre qui utilise le constructeur parent avec trois paramètres pour
     * définir le nom, les points de vie et de force
     */
    public Gobelin(){
        super("Gobelin", 6, 1);
    }
}
