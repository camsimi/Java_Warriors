package com.company;

public class HeroOutOfBoardException extends Exception {

    public HeroOutOfBoardException(){
        super("Vous ne pouvez pas sortir du plateau.");
    }
}
