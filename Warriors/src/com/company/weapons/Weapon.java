package com.company.weapons;
import com.company.Case;
import com.company.personnages.Perso;
import com.company.personnages.Warrior;
import com.company.personnages.Wizard;

public abstract class Weapon extends Case {
    protected String name;
    protected int weaponStrength;

    public Weapon(){
    }

    public Weapon (String wName, int wStrength, int num){
        super(wName, num);
        this.weaponStrength = wStrength;
    }

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeaponStrenght() {
        return weaponStrength;
    }

    public void setWeaponStrenght(int weaponStrenght) {
        this.weaponStrength = weaponStrenght;
    }

    public void addWeaponStrenght(Perso perso){
        perso.setStrength(perso.getStrength() + this.weaponStrength);
    }
}
