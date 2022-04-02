package com.nhlstenden.WildlandsTycoon.Animals.Creators;

import com.nhlstenden.WildlandsTycoon.Animals.Species.Animal;
import com.nhlstenden.WildlandsTycoon.Animals.Species.Hippo;

public class HippoCreator extends AnimalCreator {
    @Override
    public Animal createAnimal() {
        return new Hippo();
    }
}
