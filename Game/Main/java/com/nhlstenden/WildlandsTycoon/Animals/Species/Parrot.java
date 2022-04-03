package com.nhlstenden.WildlandsTycoon.Animals.Species;

import com.nhlstenden.WildlandsTycoon.Animals.Enums.*;
import com.nhlstenden.WildlandsTycoon.Animals.State;

public class Parrot extends Animal{

    public Parrot() {
        this.baseAppeal = 10.0;
        this.dailyHoursOfSleep = 12.0;
        //Temperature in C°
        this.maxTemperature = 42.0;
        this.minTemperature = 8.0;

        this.habitat = Habitat.JUNGLE;
        this.species = AnimalSpecies.PARROT;
        this.state = new State();
    }

    @Override
    public int feed() {
        this.state.setHunger(0);
        return 20;
    }

}
