package com.nhlstenden.WildlandsTycoon.Animals.Species;

import com.nhlstenden.WildlandsTycoon.Animals.Enums.*;
import com.nhlstenden.WildlandsTycoon.Animals.State;

public class Tiger extends Animal{

    public Tiger() {
        this.baseAppeal = 90.0;
        this.dailyHoursOfSleep = 16.0;
        //Temperature in C°
        this.maxTemperature = 28.0;
        this.minTemperature = -4.0;

        this.habitat = Habitat.MOUNTAIN;
        this.species = AnimalSpecies.TIGER;
        this.state = new State();
    }

    @Override
    public int feed() {
        this.state.setHunger(0);
        return 120;
    }

}
