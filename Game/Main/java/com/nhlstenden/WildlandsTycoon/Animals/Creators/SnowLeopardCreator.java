package com.nhlstenden.WildlandsTycoon.Animals.Creators;

import com.nhlstenden.WildlandsTycoon.Animals.Species.Animal;
import com.nhlstenden.WildlandsTycoon.Animals.Species.SnowLeopard;

public class SnowLeopardCreator extends AnimalCreator {
    @Override
    public Animal createAnimal() {
        return new SnowLeopard();
    }
}
