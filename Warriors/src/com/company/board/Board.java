package com.company.board;

import com.company.enemies.Dragon;
import com.company.enemies.Goblin;
import com.company.enemies.Witch;
import com.company.potions.BigPotion;
import com.company.potions.StandardPotion;
import com.company.spells.Lightning;
import com.company.spells.Fire;
import com.company.weapons.Hammer;
import com.company.weapons.Sword;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Représente un plateau avec des cases définies
 */
public class Board extends Square {
    ArrayList<Square> board;
    private final int boardLength = 64;

    /**
     * Permet la construction d'un objet de type Plateau en remplissant un attribut plateau de type
     * ArrayList avec différentes cases représentés par des objets de type Ennemi, Weapon, Spell, Potion ou CaseVide
     */
    public Board() {
        this.board = new ArrayList<Square>(this.boardLength);
        for (int i = 0; i < this.boardLength; i++) {
            switch (i) {
                case 45, 52, 56, 62 -> board.add(new Dragon());
                case 10, 20, 25, 32, 35, 36, 37, 40, 44, 47 -> board.add(new Witch());
                case 3, 6, 9, 12, 15, 18, 21, 24, 27, 30 -> board.add(new Goblin());
                case 2, 11, 5, 22, 38 -> board.add(new Hammer());
                case 19, 26, 42, 53 -> board.add(new Sword());
                case 1, 4, 8, 17, 23 -> board.add(new Lightning());
                case 48, 49 -> board.add(new Fire());
                case 7, 13, 31, 33, 39, 43 -> board.add(new StandardPotion());
                case 28, 41 -> board.add(new BigPotion());
                default -> board.add(new EmptySquare());
            }
        }
    }

    /**
     * Méthode qui permet de mélanger aléatoirement les cases du plateau
     */
    public void randomizeBoard(){
        Collections.shuffle(board);
    }

    public int getBoardLength() {
        return boardLength;
    }

    public Square getCase(int numCase) {
        return board.get(numCase);
    }

    public void setCase(int numCase, Square Square){
        board.set(numCase, Square);
    }
}
