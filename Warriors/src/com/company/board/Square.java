package com.company.board;

import com.company.heroes.Hero;

/**
 * Permet de construire un objet de type Case par défaut
 */
public abstract class Square implements Interact {
    private String name;

    public Square(){
    }

    public Square(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString(){
       return this.name;
    }

    @Override
    public void interact(Hero hero, Board board) {
        System.out.println("Aucune interaction avec " + this.getName() + ", poursuis ta route.");
    }
}
