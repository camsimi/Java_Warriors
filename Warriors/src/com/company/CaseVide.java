package com.company;

import com.company.personnages.Perso;

public class CaseVide extends Case implements Interact{

    public CaseVide(){
        super("CaseVide");
    }

    @Override
    public void interact(Perso perso, Plateau plateau) {
        System.out.println("Aucune interaction avec " + perso.getName() + ", poursuis ta route.");
    }
}
