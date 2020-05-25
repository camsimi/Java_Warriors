package com.company.personnages;
import com.company.spells.Spell;

public class Wizard extends Perso {
    private Spell spell;

    public Wizard() {
        super("Anonymous wizard", 3, 8);
    }

    public Wizard(String n){
        super(n, 3, 8);
    }

    public void setLife(int life) {
        if ((life>=3) && (life<=6) ) {
            setLife(life);
        } else {
            System.out.println("You must enter a life inferior to 10.");
        }
    }

    public void setStrength(int strength) {
        if ( (strength >=8) && (strength <=15) ) {
            super.setStrength(strength);
        } else if (strength > 15){
            super.setStrength(15);
            System.out.println("Your maximum strength is 15");
        }
    }

    public Spell getSpell() {
        return spell;
    }

    public void setSpell(Spell spell) {
        this.spell = spell;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", mon sort est un " + spell;
    }
}