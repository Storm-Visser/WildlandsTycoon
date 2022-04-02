package com.nhlstenden.WildlandsTycoon.Animals.Creators;

import com.nhlstenden.WildlandsTycoon.Animals.Species.Animal;
import com.nhlstenden.WildlandsTycoon.Animals.Species.Tortoise;

public class TortoiseCreator extends AnimalCreator {
    @Override
    public Animal createAnimal() {
        return new Tortoise();
    }
}
