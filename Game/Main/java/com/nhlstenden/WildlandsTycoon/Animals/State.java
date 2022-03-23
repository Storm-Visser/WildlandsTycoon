package com.nhlstenden.WildlandsTycoon.Animals;

public class State {

    private boolean isSleeping;
    //These variables will contain a rating from 0 to 100, with 0 being good and 100 bad.
    private int hunger;
    private int temperatureContentment;
    private int stress;

    public State() {
        isSleeping = false;
        hunger = 0;
        temperatureContentment = 0;
        stress = 0;
    }
}
