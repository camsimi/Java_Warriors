package com.company.ennemis;

import com.company.Case;
import com.company.personnages.Perso;
import com.company.personnages.Warrior;
import com.company.personnages.Wizard;

public class Ennemi extends Case {

    @Override
    public void interact(Perso perso) {
        if (perso instanceof Wizard){
            System.out.println("");
        } else if (perso instanceof Warrior){
            System.out.println("");
        } else {
            System.out.println("");
        }
    }
}
