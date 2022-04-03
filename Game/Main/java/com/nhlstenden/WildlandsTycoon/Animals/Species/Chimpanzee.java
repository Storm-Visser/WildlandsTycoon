package com.nhlstenden.WildlandsTycoon.Animals.Species;

import com.nhlstenden.WildlandsTycoon.Animals.Enums.*;
import com.nhlstenden.WildlandsTycoon.Animals.State;

public class Chimpanzee extends Animal{

    public Chimpanzee() {
        this.baseAppeal = 40.0;
        this.dailyHoursOfSleep = 10.0;
        //Temperature in C°
        this.maxTemperature = 42.0;
        this.minTemperature = 8.0;

        this.habitat = Habitat.JUNGLE;
        this.species = AnimalSpecies.CHIMPANZEE;
        this.state = new State();
    }

    @Override
    public int feed() {
        this.state.setHunger(0);
        return 80;
    }
}
