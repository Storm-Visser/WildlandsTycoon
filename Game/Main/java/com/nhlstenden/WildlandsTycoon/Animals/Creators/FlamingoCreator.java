package com.nhlstenden.WildlandsTycoon.Animals.Creators;

import com.nhlstenden.WildlandsTycoon.Animals.Species.Animal;
import com.nhlstenden.WildlandsTycoon.Animals.Species.Flamingo;

public class FlamingoCreator extends AnimalCreator {
    @Override
    public Animal createAnimal() {
        return new Flamingo();
    }
}
