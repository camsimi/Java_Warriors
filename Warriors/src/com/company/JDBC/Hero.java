package com.company.JDBC;

public class Hero {
    private int id;
    private String name;
    private int life;
    private int strength;

    public Hero(){

    }

    public Hero(int id, String name, int life, int strength) {
        this.id = id;
        this.name = name;
        this.life = life;
        this.strength = strength;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }
}
