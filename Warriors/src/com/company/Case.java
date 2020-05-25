package com.company;

import com.company.personnages.Perso;

public abstract class Case {
    protected String name = "";
    protected int num;

    public Case(){

    }

    public Case(String name){
        this.name = name;
    }

    public Case(String name, int num){
        this.name = name;
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    @Override
    public String toString(){
       return this.name;
    }

    public void interact(Perso perso){

        System.out.println("Interaction avec " + perso.getName());
    }
}
