package com.nhlstenden.WildlandsTycoon.Animals.Creators;

import com.nhlstenden.WildlandsTycoon.Animals.Species.Animal;
import com.nhlstenden.WildlandsTycoon.Animals.Species.Crocodile;

public class CrocodileCreator extends AnimalCreator{
    @Override
    public Animal createAnimal() {
        return new Crocodile();
    }
}
