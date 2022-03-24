package com.nhlstenden.WildlandsTycoon.Animals.Species;

import com.nhlstenden.WildlandsTycoon.Animals.Habitat;
import com.nhlstenden.WildlandsTycoon.Animals.State;

public class NullAnimal extends Animal{

    public NullAnimal() {
        this.baseAppeal = 0.0;
        this.dailyHoursOfSleep = 0.0;
        //Temperature in C°
        this.maxTemperature = 0.0;
        this.minTemperature = 0.0;

        this.habitat = null;
        this.state = null;
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
