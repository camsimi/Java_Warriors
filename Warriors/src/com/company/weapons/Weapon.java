package com.company.weapons;
import com.company.heroes.Hero;
import com.company.board.Square;
import com.company.board.Board;
import com.company.heroes.Warrior;
import com.company.heroes.Wizard;

public abstract class Weapon extends Square {
    protected int weaponStrength;

    public Weapon(){
    }

    public Weapon (String wName, int wStrength){
        super(wName);
        this.weaponStrength = wStrength;
    }

    @Override
    public void interact(Hero hero, Board board) {
        if (hero instanceof Wizard){
            System.out.println("Oh une arme, c'est nul je ne peux pas la prendre, je suis une magicienne!");
        }
        else if (hero instanceof Warrior){
            System.out.println("Youpi, je suis maintenant armée d'une " + getName() + ", " + getWeaponStrength() + " points de force supplémentaires!");
            ((Warrior) hero).setWeapon(this);
            addWeaponStrength(hero);
        }
    }

    public int getWeaponStrength() {
        return weaponStrength;
    }

    public void addWeaponStrength(Hero hero){
        hero.setStrength(hero.getStrength() + this.weaponStrength);
    }
}
