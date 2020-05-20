package com.company;

import com.company.ennemis.Dragon;
import com.company.ennemis.Gobelin;
import com.company.ennemis.Sorcier;
import com.company.potions.BigPotion;
import com.company.potions.StandardPotion;
import com.company.spells.Eclair;
import com.company.spells.Fire;
import com.company.weapons.Epee;
import com.company.weapons.Massue;

import java.util.ArrayList;

public class Plateau extends Case {
    ArrayList<Case> plateau = new ArrayList<Case>(64);
    private int plateauLength;

    public Plateau() {
        for (int i = 1; i < 65; i++) {
            switch (i) {
                case 45, 52, 56, 62 -> plateau.add(new Dragon(i));
                case 10, 20, 25, 32, 35, 36, 37, 40, 44, 47 -> plateau.add(new Sorcier(i));
                case 3, 6, 9, 12, 15, 18, 21, 24, 27, 30 -> plateau.add(new Gobelin(i));
                case 2, 11, 5, 22, 38 -> plateau.add(new Massue(i));
                case 19, 26, 42, 53 -> plateau.add(new Epee(i));
                case 1, 4, 8, 17, 23 -> plateau.add(new Eclair(i));
                case 48, 49 -> plateau.add(new Fire(i));
                case 7, 13, 31, 33, 39, 43 -> plateau.add(new StandardPotion(i));
                case 28, 41 -> plateau.add(new BigPotion(i));
                default -> plateau.add(new CaseVide(i));
            }
        }
        this.plateauLength = plateau.size();
    }

    public ArrayList<Case> getPlateau() {
        return plateau;
    }

    public void setPlateau(ArrayList<Case> plateau) {
        this.plateau = plateau;
    }

    public int getPlateauLength() {
        return plateauLength;
    }

    public void setPlateauLength(int plateauLength) {
        this.plateauLength = plateauLength;
    }
}
