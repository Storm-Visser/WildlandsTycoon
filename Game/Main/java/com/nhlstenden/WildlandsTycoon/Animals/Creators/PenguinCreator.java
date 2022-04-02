package com.nhlstenden.WildlandsTycoon.Animals.Creators;

import com.nhlstenden.WildlandsTycoon.Animals.Species.Animal;
import com.nhlstenden.WildlandsTycoon.Animals.Species.Penguin;

public class PenguinCreator extends AnimalCreator {
    @Override
    public Animal createAnimal() {
        return new Penguin();
    }
}
