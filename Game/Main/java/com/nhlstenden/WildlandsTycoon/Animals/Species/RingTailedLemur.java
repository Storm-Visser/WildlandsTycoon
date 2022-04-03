package com.nhlstenden.WildlandsTycoon.Animals.Species;

import com.nhlstenden.WildlandsTycoon.Animals.Enums.*;
import com.nhlstenden.WildlandsTycoon.Animals.State;

public class RingTailedLemur extends Animal{

    public RingTailedLemur() {
        this.baseAppeal = 20.0;
        this.dailyHoursOfSleep = 16.0;
        //Temperature in C°
        this.maxTemperature = 42.0;
        this.minTemperature = 10.0;

        this.habitat = Habitat.JUNGLE;
        this.species = AnimalSpecies.RING_TAILED_LEMUR;
        this.state = new State();
    }

    @Override
    public int feed() {
        this.state.setHunger(0);
        return 40;
    }

}
