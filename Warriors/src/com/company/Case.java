package com.company;

import com.company.personnages.Perso;

public abstract class Case {

    public void interact(Perso perso){
        System.out.println("Interaction avec :" + perso.getName());
    }
}
