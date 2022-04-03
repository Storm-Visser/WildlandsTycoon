package com.nhlstenden.WildlandsTycoon.Animals.Species;

import com.nhlstenden.WildlandsTycoon.Animals.Enums.*;
import com.nhlstenden.WildlandsTycoon.Animals.State;

public class Tortoise extends Animal{

    public Tortoise() {
        this.baseAppeal = 20.0;
        this.dailyHoursOfSleep = 12.0;
        //Temperature in C°
        this.maxTemperature = 42.0;
        this.minTemperature = 14.0;

        this.habitat = Habitat.AQUATIC;
        this.species = AnimalSpecies.TORTOISE;
        this.state = new State();
    }

    @Override
    public int feed() {
        this.state.setHunger(0);
        return 20;
    }

}
