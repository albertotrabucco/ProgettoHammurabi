package com.example.progettohammurabi.model.repository;

import com.example.progettohammurabi.model.Hammurabi;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HammurabiRepository {

    static final String DB_URL = "jdbc:mysql://localhost:3306/java";
    static final String USER = "java";
    static final String PASS = "java";


    public static List<Hammurabi> getDati() {
        //creo una lista da restituire
        List<Hammurabi> dati = new ArrayList<>();

        try {
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            PreparedStatement stmt = conn.prepareStatement("select pop, grano, terreno from hammurabi");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                //creo un set di dati con i dati del DB
                Hammurabi dato = new Hammurabi(rs.getInt("pop"), rs.getInt("grano"), rs.getInt("terreno"));
                //aggiungo alla lista
                dati.add(dato);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dati;
    }
}

    /*public static String createTable(){
        try{
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = conn.createStatement();
            stmt.execute("create table hammurabi2 (" +
                    "pop NOT NULL INTEGER(3) SET DEFAULT 10," +
                    "grano NOT NULL INTEGER(4) SET DEFAULT 30, " +
                    "terreno NOT NULL INTEGER(2) SET DEFAULT 0)");
            stmt.execute("insert into hammurabi2 values(,'','')");
            ResultSet rs = stmt.executeQuery("select * from hammurabi2");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return "Tabella Creata!";
    }

}*/
