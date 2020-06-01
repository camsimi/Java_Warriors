package com.company.bdd;
import java.nio.channels.SelectableChannel;
import java.sql.*;

public class Query {

    public static String getHeroes(){
        return "SELECT * FROM Hero";
    }

    public static String getHero(){
        return "SELECT * FROM Hero WHERE ID = 2";
    }

    public void createHero(){

    }

    public void updateHero(int id){

    }

    public void deleteHero(int id){

    }
}
