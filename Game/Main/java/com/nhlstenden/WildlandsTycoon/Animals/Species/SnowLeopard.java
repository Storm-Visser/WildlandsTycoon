package com.nhlstenden.WildlandsTycoon.Animals.Species;

import com.nhlstenden.WildlandsTycoon.Animals.Enums.AnimalSpecies;
import com.nhlstenden.WildlandsTycoon.Animals.Enums.Habitat;
import com.nhlstenden.WildlandsTycoon.Animals.State;

public class SnowLeopard extends Animal{

    public SnowLeopard() {
        this.baseAppeal = 80.0;
        this.dailyHoursOfSleep = 14.0;
        //Temperature in C°
        this.maxTemperature = 25.0;
        this.minTemperature = -4.0;

        this.habitat = Habitat.MOUNTAIN;
        this.species = AnimalSpecies.SNOW_LEOPARD;
        this.state = new State();
    }

    @Override
    public int feed() {
        this.state.setHunger(0);
        return 120;
    }

}
