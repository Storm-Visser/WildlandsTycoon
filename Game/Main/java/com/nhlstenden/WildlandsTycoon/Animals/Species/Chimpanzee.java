package com.nhlstenden.WildlandsTycoon.Animals.Species;

import com.nhlstenden.WildlandsTycoon.Animals.Enums.*;
import com.nhlstenden.WildlandsTycoon.Animals.State;

public class Chimpanzee extends Animal{

    public Chimpanzee() {
        this.baseAppeal = 20.0;
        this.dailyHoursOfSleep = 8.0;
        //Temperature in C°
        this.maxTemperature = 40.0;
        this.minTemperature = 10.0;

        this.habitat = Habitat.JUNGLE;
        this.species = AnimalSpecies.CHIMPANZEE;
        this.state = new State();
    }

    @Override
    public void feed() {
        this.state.setHunger(0);
        System.out.println("Fed Chimpanzee");
    }

    @Override
    public void wakeUp() {
        this.state.setSleeping(false);
        System.out.println("Chimpanzee woke up");
    }

    @Override
    public void sleep() {
        this.state.setSleeping(true);
        System.out.println("Chimpanzee fell asleep");
    }
}
