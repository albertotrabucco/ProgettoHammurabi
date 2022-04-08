package com.example.progettohammurabi.model.repository;

import com.example.progettohammurabi.model.Hammurabi;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HammurabiRepository {

    static final String DB_URL = "jdbc:mysql://localhost:3306/java";  //cambiare la porta in 8080 quando si è in engim e 3306 quando a casa
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


    public static String createTable(){
        try{
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = conn.createStatement();
            stmt.executeUpdate("CREATE TABLE hammurabi" +
                    "(pop INTEGER(3) DEFAULT 10," +
                    "grano INTEGER(4) DEFAULT 30, " +
                    "terreno INTEGER(2) DEFAULT 0)");
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        return "Tabella Creata!";
    }


    public static String setDati(){ //1turno inizio partita
        try {
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = conn.createStatement();
            stmt.executeUpdate("INSERT INTO hammurabi (pop,grano,terreno) VALUE (DEFAULT (pop), DEFAULT (grano), DEFAULT (terreno))");
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return "Dati turno 1 inizializzati ai valori di default con successo!";
    }


    public static String deleteTable(){
        try{
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = conn.createStatement();
            stmt.executeUpdate("DROP TABLE hammurabi");
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return "Tabella cancellata con successo!";
    }
}
