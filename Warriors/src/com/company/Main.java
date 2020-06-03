package com.company;

import com.company.bdd.Connexion;
import com.company.bdd.Query;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        try {
            Query.getHero(Connexion.getInstance());
            Query.createHero(Connexion.getInstance());
            Query.updateHero(Connexion.getInstance());
            Query.deleteHero(Connexion.getInstance(), 3);
            Query.getHeroes(Connexion.getInstance());
        } catch (SQLException e) {
            e.printStackTrace();
        }
//        finally {
//            state.close();
//            result.close();
//        }
    }
}