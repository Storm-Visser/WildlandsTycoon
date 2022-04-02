package com.nhlstenden.WildlandsTycoon.Animals.Species;

import com.nhlstenden.WildlandsTycoon.Animals.Enums.*;
import com.nhlstenden.WildlandsTycoon.Animals.State;

public class Penguin extends Animal{

    public Penguin() {
        this.baseAppeal = 20.0;
        this.dailyHoursOfSleep = 8.0;
        //Temperature in C°
        this.maxTemperature = 40.0;
        this.minTemperature = 10.0;

        this.habitat = Habitat.ARCTIC;
        this.species = AnimalSpecies.PENGUIN;
        this.state = new State();
    }

    @Override
    public int feed() {
        this.state.setHunger(0);
        return 50;
    }

}
