package com.company.personnages;

public class PersonnageHorsPlateauException extends Exception {

    public PersonnageHorsPlateauException(){
        super("Vous ne pouvez pas aller au-delà de la case 64.");
    }
}
