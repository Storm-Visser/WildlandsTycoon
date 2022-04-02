package com.nhlstenden.WildlandsTycoon.Animals.Creators;

import com.nhlstenden.WildlandsTycoon.Animals.Species.Animal;
import com.nhlstenden.WildlandsTycoon.Animals.Species.RingTailedLemur;

public class RingTailedLemurCreator extends AnimalCreator {
    @Override
    public Animal createAnimal() {
        return new RingTailedLemur();
    }
}
