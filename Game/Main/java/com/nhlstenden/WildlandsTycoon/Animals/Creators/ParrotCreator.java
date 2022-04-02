package com.nhlstenden.WildlandsTycoon.Animals.Creators;

import com.nhlstenden.WildlandsTycoon.Animals.Species.Animal;
import com.nhlstenden.WildlandsTycoon.Animals.Species.Parrot;

public class ParrotCreator extends AnimalCreator {
    @Override
    public Animal createAnimal() {
        return new Parrot();
    }
}
