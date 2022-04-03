package com.nhlstenden.WildlandsTycoon.Animals.Species;

import com.nhlstenden.WildlandsTycoon.Animals.Enums.*;
import com.nhlstenden.WildlandsTycoon.Animals.State;

public class Flamingo extends Animal{

    public Flamingo() {
        this.baseAppeal = 20.0;
        this.dailyHoursOfSleep = 10.0;
        //Temperature in C°
        this.maxTemperature = 40.0;
        this.minTemperature = 8.0;

        this.habitat = Habitat.SAVANNA;
        this.species = AnimalSpecies.FLAMINGO;
        this.state = new State();
    }

    @Override
    public int feed() {
        this.state.setHunger(0);
        return 30;
    }
}
