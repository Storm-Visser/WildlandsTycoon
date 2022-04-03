package com.nhlstenden.WildlandsTycoon.Animals.Species;

import com.nhlstenden.WildlandsTycoon.Animals.Enums.*;
import com.nhlstenden.WildlandsTycoon.Animals.State;

public class Penguin extends Animal{

    public Penguin() {
        this.baseAppeal = 30.0;
        this.dailyHoursOfSleep = 16.0;
        //Temperature in C°
        this.maxTemperature = 32.0;
        this.minTemperature = -60.0;

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
