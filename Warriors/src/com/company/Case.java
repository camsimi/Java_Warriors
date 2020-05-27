package com.company;

import com.company.personnages.Perso;

import java.util.ArrayList;

public abstract class Case {
    protected String name = "";

    public Case(){

    }

    public Case(String name){
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

    public void interact(Perso perso, Plateau plateau){
        System.out.println("Aucune interaction avec " + perso.getName() + ", poursuis ta route.");
    }
}
