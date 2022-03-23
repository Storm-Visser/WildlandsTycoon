package com.nhlstenden.WildlandsTycoon.Animals;

public class State {

    private boolean isSleeping;
    //These variables will contain a rating from 0 to 100, with 0 being good and 100 bad.
    private double hunger;
    private double temperatureContentment;
    private double stress;
    private double fatigue;

    public State() {
        isSleeping = false;
        hunger = 0;
        temperatureContentment = 0;
        stress = 0;
        fatigue = 0;
    }

    public double getFatigue() {
        return fatigue;
    }

    public void setFatigue(double fatigue) {
        this.fatigue = fatigue;
    }

    public boolean isSleeping() {
        return isSleeping;
    }

    public void setSleeping(boolean sleeping) {
        isSleeping = sleeping;
    }

    public double getHunger() {
        return hunger;
    }

    public void setHunger(double hunger) {
        if (hunger > 0){
            this.hunger = hunger;
        } else {
            this.hunger = 0;
        }
    }

    public double getTemperatureContentment() {
        return temperatureContentment;
    }

    public void setTemperatureContentment(double temperatureContentment) {
        if (temperatureContentment > 0){
            this.temperatureContentment = temperatureContentment;
        } else {
            this.temperatureContentment = 0;
        }
    }

    public double getStress() {
        return stress;
    }

    public void setStress(double stress) {
        if (stress > 0){
            this.stress = stress;
        } else {
            this.stress = 0;
        }
    }
}
