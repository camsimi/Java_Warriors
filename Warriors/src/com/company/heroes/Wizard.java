package com.company.heroes;
import com.company.spells.Spell;

/**
 * Représente l'objet Wizard
 */
public class Wizard extends Hero {
    /**
     * attribut privé propre au magicien, représente un sort (classe abstraite de type Spell)
     */
    private Spell spell;

    /**
     * Permet de construire l'objet Wizard au moment de son instanciation
     * ne prend aucun paramètre et utilise le constructeur
     * qui prend un nom en paramètre pour instancier le nom par défaut
     */
    public Wizard() {
        this("Anonymous wizard");
    }

    /**
     * Permet de construire l'objet Wizard au moment de son instanciation.
     * Prend un paramètre qui représente le nom et utilise le constructeur parent
     * qui prend tous les attributs d'un personnage pour instancier un Wizard par défaut
     * @param n de type chaîne de caractère qui récupère le nom du Wizard
     */
    public Wizard(String n){
        super(n, 3, 8, 8, 15, 3, 6);
    }

    /**
     * Récupère le sort
     * @return objet de type Spell
     */
    public Spell getSpell() {
        return spell;
    }

    /**
     * Modifie le sort
     * @param spell de type Spell
     */
    public void setSpell(Spell spell) {
        this.spell = spell;
    }

    /**
     * Décrit l'objet Wizard en utilisant la méthode parente et en ajoutant la description du sort
     * @return une chaîne de caractère qui représente l'objet
     */
    @Override
    public String toString() {
        if (spell != null) {
            return super.toString() +
                    ", mon sort est un(e) " + spell;
        }
        else {
            return super.toString();
        }
    }
}