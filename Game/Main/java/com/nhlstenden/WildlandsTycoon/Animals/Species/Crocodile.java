package com.nhlstenden.WildlandsTycoon.Animals.Species;

import com.nhlstenden.WildlandsTycoon.Animals.Enums.*;
import com.nhlstenden.WildlandsTycoon.Animals.State;

public class Crocodile extends Animal{

    public Crocodile() {
        this.baseAppeal = 50.0;
        this.dailyHoursOfSleep = 14.0;
        //Temperature in C°
        this.maxTemperature = 42.0;
        this.minTemperature = 12.0;

        this.habitat = Habitat.AQUATIC;
        this.species = AnimalSpecies.CROCODILE;
        this.state = new State();
    }

    @Override
    public int feed() {
        this.state.setHunger(0);
        return 150;
    }
}
