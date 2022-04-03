package com.nhlstenden.WildlandsTycoon.Animals.Species;

import com.nhlstenden.WildlandsTycoon.Animals.Enums.*;
import com.nhlstenden.WildlandsTycoon.Animals.State;

public class Gorilla extends Animal{

    public Gorilla() {
        this.baseAppeal = 80.0;
        this.dailyHoursOfSleep = 12.0;
        //Temperature in C°
        this.maxTemperature = 42.0;
        this.minTemperature = 8.0;

        this.habitat = Habitat.JUNGLE;
        this.species = AnimalSpecies.GORILLA;
        this.state = new State();
    }

    @Override
    public int feed() {
        this.state.setHunger(0);
        return 120;
    }

}
