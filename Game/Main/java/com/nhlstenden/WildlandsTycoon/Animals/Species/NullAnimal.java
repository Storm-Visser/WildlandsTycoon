package com.nhlstenden.WildlandsTycoon.Animals.Species;

import com.nhlstenden.WildlandsTycoon.Animals.Enums.AnimalSpecies;
import com.nhlstenden.WildlandsTycoon.Animals.State;

public class NullAnimal extends Animal{

    public NullAnimal() {
        this.baseAppeal = 0.0;
        this.dailyHoursOfSleep = 0.0;
        //Temperature in C°
        this.maxTemperature = 0.0;
        this.minTemperature = 0.0;

        this.habitat = null;
        this.species = AnimalSpecies.NULL_ANIMAL;
        this.state = new State();
    }
    @Override
    public double getAppeal() {
        return 0.0;
    }

    @Override
    public void update(Double temperature, int AmountOfGuests) {

    }

    @Override
    public void feed() {
    }

    @Override
    public void wakeUp() {
    }

    @Override
    public void sleep() {
    }
}
