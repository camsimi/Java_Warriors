package com.company;

import com.company.ennemis.Dragon;

import java.util.ArrayList;

public class Plateau extends Case {
    ArrayList<Case> plateau = new ArrayList<Case>();

    public Plateau() {

        plateau.add(new Dragon(45));
        plateau.add(new Dragon(52));
        plateau.add(new Dragon(56));
        plateau.add(new Dragon(62));

    }
}
