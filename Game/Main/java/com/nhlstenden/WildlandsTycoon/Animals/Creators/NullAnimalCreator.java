package com.nhlstenden.WildlandsTycoon.Animals.Creators;

import com.nhlstenden.WildlandsTycoon.Animals.Species.Animal;
import com.nhlstenden.WildlandsTycoon.Animals.Species.NullAnimal;

public class NullAnimalCreator extends AnimalCreator {
    @Override
    public Animal createAnimal() {
        return new NullAnimal();
    }
}
