package com.nhlstenden.WildlandsTycoon.Animals.Species;

import com.nhlstenden.WildlandsTycoon.Animals.Habitat;
import com.nhlstenden.WildlandsTycoon.Animals.State;

public class Flamingo extends Animal{

    public Flamingo() {
        this.baseAppeal = 20.0;
        this.dailyHoursOfSleep = 8.0;
        //Temperature in C°
        this.maxTemperature = 40.0;
        this.minTemperature = 10.0;

        this.habitat = Habitat.AQUATIC;
        this.state = new State();
    }

    @Override
    public void feed() {
        this.state.setHunger(0);
        System.out.println("Fed Flamingo");
    }

    @Override
    public void wakeUp() {
        this.state.setSleeping(false);
        System.out.println("Flamingo woke up");
    }

    @Override
    public void sleep() {
        this.state.setSleeping(true);
        System.out.println("Flamingo fell asleep");
    }
}
