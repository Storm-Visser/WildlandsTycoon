package com.nhlstenden.WildlandsTycoon.Animals.Species;

import com.nhlstenden.WildlandsTycoon.Animals.Enums.*;
import com.nhlstenden.WildlandsTycoon.Animals.State;

public class Tiger extends Animal{

    public Tiger() {
        this.baseAppeal = 20.0;
        this.dailyHoursOfSleep = 8.0;
        //Temperature in C°
        this.maxTemperature = 40.0;
        this.minTemperature = 10.0;

        this.habitat = Habitat.SAVANNA;
        this.species = AnimalSpecies.TIGER;
        this.state = new State();
    }

    @Override
    public int feed() {
        this.state.setHunger(0);
        return 50;
    }

}
