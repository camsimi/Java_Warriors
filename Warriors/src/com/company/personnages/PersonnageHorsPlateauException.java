package com.company.personnages;

public class PersonnageHorsPlateauException extends Exception {

    public PersonnageHorsPlateauException(){
        super("Vous ne pouvez pas sortir du plateau.");
    }
}
