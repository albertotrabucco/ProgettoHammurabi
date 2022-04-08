package com.example.progettohammurabi.model;

public class Hammurabi {
    private int turno;
    private int population;
    private int wheat;
    private int land;

    public Hammurabi() {
    }

    public Hammurabi(int turno, int population, int wheat, int land) {
        this.turno = turno;
        this.population = population;
        this.wheat = wheat;
        this.land = land;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public int getWheat() {
        return wheat;
    }

    public void setWheat(int wheat) {
        this.wheat = wheat;
    }

    public int getLand() {
        return land;
    }

    public void setLand(int land) {
        this.land = land;
    }

    public int getTurno() {
        return turno;
    }

    public void setTurno(int turno) {
        this.turno = turno;
    }

    @Override
    public String toString() {
        return "Hammurabi{" +
                "turno=" + turno +
                ", population=" + population +
                ", wheat=" + wheat +
                ", land=" + land +
                '}';
    }
}
