package com.nhlstenden.WildlandsTycoon.Animals.Creators;

import com.nhlstenden.WildlandsTycoon.Animals.Species.Animal;
import com.nhlstenden.WildlandsTycoon.Animals.Species.Lion;

public class LionCreator extends AnimalCreator {
    @Override
    public Animal createAnimal() {
        return new Lion();
    }
}
