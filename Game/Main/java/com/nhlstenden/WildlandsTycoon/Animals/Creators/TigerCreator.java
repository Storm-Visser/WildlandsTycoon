package com.nhlstenden.WildlandsTycoon.Animals.Creators;

import com.nhlstenden.WildlandsTycoon.Animals.Species.Animal;
import com.nhlstenden.WildlandsTycoon.Animals.Species.Tiger;

public class TigerCreator extends AnimalCreator {
    @Override
    public Animal createAnimal() {
        return new Tiger();
    }
}
