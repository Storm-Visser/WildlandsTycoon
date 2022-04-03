package com.nhlstenden.WildlandsTycoon.Animals.Species;

import com.nhlstenden.WildlandsTycoon.Animals.Enums.*;
import com.nhlstenden.WildlandsTycoon.Animals.State;

public class Hippo extends Animal{

    public Hippo() {
        this.baseAppeal = 70.0;
        this.dailyHoursOfSleep = 13.0;
        //Temperature in C°
        this.maxTemperature = 38.0;
        this.minTemperature = 10.0;

        this.habitat = Habitat.AQUATIC;
        this.species = AnimalSpecies.HIPPO;
        this.state = new State();
    }

    @Override
    public int feed() {
        this.state.setHunger(0);
        return 120;
    }

}
