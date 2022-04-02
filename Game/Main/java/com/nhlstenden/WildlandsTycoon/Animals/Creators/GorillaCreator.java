package com.nhlstenden.WildlandsTycoon.Animals.Creators;

import com.nhlstenden.WildlandsTycoon.Animals.Species.Animal;
import com.nhlstenden.WildlandsTycoon.Animals.Species.Gorilla;

public class GorillaCreator extends AnimalCreator {
    @Override
    public Animal createAnimal() {
        return new Gorilla();
    }
}
