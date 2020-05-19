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
    ArrayList<Case> plateau = new ArrayList<Case>();

    public Plateau() {
// -------------CASE ENNEMIS -------------
// Ajout cases Dragon
        plateau.add(new Dragon(45));
        plateau.add(new Dragon(52));
        plateau.add(new Dragon(56));
        plateau.add(new Dragon(62));

// Ajout cases Sorcier
        plateau.add(new Sorcier(10));
        plateau.add(new Sorcier(20));
        plateau.add(new Sorcier(25));
        plateau.add(new Sorcier(32));
        plateau.add(new Sorcier(35));
        plateau.add(new Sorcier(36));
        plateau.add(new Sorcier(37));
        plateau.add(new Sorcier(40));
        plateau.add(new Sorcier(44));
        plateau.add(new Sorcier(47));

// Ajout cases Gobelin
        plateau.add(new Gobelin(3));
        plateau.add(new Gobelin(6));
        plateau.add(new Gobelin(9));
        plateau.add(new Gobelin(12));
        plateau.add(new Gobelin(15));
        plateau.add(new Gobelin(18));
        plateau.add(new Gobelin(21));
        plateau.add(new Gobelin(24));
        plateau.add(new Gobelin(27));
        plateau.add(new Gobelin(30));

// ----------------CAISSES SURPRISES ----------------

// Ajout cases Massue
        plateau.add(new Massue(2));
        plateau.add(new Massue(11));
        plateau.add(new Massue(5));
        plateau.add(new Massue(22));
        plateau.add(new Massue(38));

// Ajout cases Epee
        plateau.add(new Epee(19));
        plateau.add(new Epee(26));
        plateau.add(new Epee(42));
        plateau.add(new Epee(53));

// Ajout cases Eclair
        plateau.add(new Eclair(1));
        plateau.add(new Eclair(4));
        plateau.add(new Eclair(8));
        plateau.add(new Eclair(17));
        plateau.add(new Eclair(23));

// Ajout cases Fire
        plateau.add(new Fire(48));
        plateau.add(new Fire(49));

// Ajout cases StandardPotion
        plateau.add(new StandardPotion(7));
        plateau.add(new StandardPotion(13));
        plateau.add(new StandardPotion(31));
        plateau.add(new StandardPotion(33));
        plateau.add(new StandardPotion(39));
        plateau.add(new StandardPotion(43));

// Ajout cases BigPotion
        plateau.add(new BigPotion(28));
        plateau.add(new BigPotion(41));

//-------------CASES VIDES---------------------------
        plateau.add(new CaseVide(0));
        plateau.add(new CaseVide(5));
        plateau.add(new CaseVide(14));
        plateau.add(new CaseVide(16));
        plateau.add(new CaseVide(29));
        plateau.add(new CaseVide(34));
        plateau.add(new CaseVide(46));
        plateau.add(new CaseVide(50));
        plateau.add(new CaseVide(51));
        plateau.add(new CaseVide(54));
        plateau.add(new CaseVide(55));
        plateau.add(new CaseVide(57));
        plateau.add(new CaseVide(58));
        plateau.add(new CaseVide(59));
        plateau.add(new CaseVide(60));
        plateau.add(new CaseVide(61));
        plateau.add(new CaseVide(63));
        plateau.add(new CaseVide(64));
    }
}
