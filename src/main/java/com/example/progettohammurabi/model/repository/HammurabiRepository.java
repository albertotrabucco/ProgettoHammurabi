package com.example.progettohammurabi.model.repository;

import com.example.progettohammurabi.model.Hammurabi;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HammurabiRepository {

    static final String DB_URL = "jdbc:mysql://localhost:3306/java";  //cambiare la porta in 8080 quando si è in engim e 3306 quando a casa
    static final String USER = "java";
    static final String PASS = "java";

    //stampo tutti i dati
    public static List<Hammurabi> getDati() {
        //creo una lista da restituire
        List<Hammurabi> dati = new ArrayList<>();

        try {
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            PreparedStatement stmt = conn.prepareStatement("select * from hammurabi");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                //creo un set di dati con i dati del DB
                Hammurabi dato = new Hammurabi(rs.getInt("turno"),rs.getInt("pop"), rs.getInt("grano"), rs.getInt("terreno"));
                //aggiungo alla lista
                dati.add(dato);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dati;
    }

    //creo la tabella
    public static String createTable(){
        try{
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = conn.createStatement();
            stmt.executeUpdate("CREATE TABLE hammurabi" +
                    "(turno INTEGER(2) PRIMARY KEY AUTO_INCREMENT," +
                    "pop INTEGER(3) NOT NULL DEFAULT 10," +
                    "grano INTEGER(4) NOT NULL DEFAULT 30, " +
                    "terreno INTEGER(2) NOT NULL DEFAULT 0)");
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        return "Tabella Creata!";
    }

    //Inserisco i dati di inizio partita
    public static String setDati(){
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

    //Cacello la tabella
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

    /*
     * Nel controller ci sarà un ciclo che creerà una nuova riga nella tabella con valori di uguali a quelli della riga precedente con newTurn()
     * Prenderà i dati inseriti dal giocatore tramite angular
     * modificherà la nuova riga della tabella con i dati ottenuti da angular
     */
    //inserisco i dati dei turni successivi al primo
    public static String setDatiTurn(int turno, int popolazione, int grano, int terreno){
        try{
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);

            //creo la nuova riga uguale a quella precedente
            Statement newStmt = conn.createStatement();
            newStmt.executeUpdate("INSERT INTO hammurabi (pop,grano,terreno) SELECT pop, grano, terreno FROM hammurabi WHERE turno= " + (turno-1));

            //modifico i dati della nuova riga con quelli di angular
            Statement updateStmt = conn.createStatement();
            updateStmt.executeUpdate("UPDATE hammurabi " +
                    "SET pop= " + popolazione +
                    ", grano = " + grano +
                    ", terreno = " + terreno +
                    " WHERE turno = " + turno +
                    ";"
            );
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return "Dati aggiunti correttamente!";
    }
}
