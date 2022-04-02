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
        if (fatigue < 0){
            this.fatigue = 0;
        } else if (fatigue > 100) {
            this.fatigue = 100;
        } else {
            this.fatigue = fatigue;
        }
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
        if (hunger < 0){
            this.hunger = 0;
        } else if (hunger > 100) {
            this.hunger = 100;
        } else {
            this.hunger = hunger;
        }
    }

    public double getTemperatureContentment() {
        return temperatureContentment;
    }

    public void setTemperatureContentment(double temperatureContentment) {
        if (temperatureContentment < 0){
            this.temperatureContentment = 0;
        } else if (temperatureContentment > 100) {
            this.temperatureContentment = 100;
        } else {
            this.temperatureContentment = temperatureContentment;
        }
    }

    public double getStress() {
        return stress;
    }

    public void setStress(double stress) {
        if (stress < 0){
            this.stress = 0;
        } else if (stress > 100) {
            this.stress = 100;
        } else {
            this.stress = stress;
        }
    }
}
