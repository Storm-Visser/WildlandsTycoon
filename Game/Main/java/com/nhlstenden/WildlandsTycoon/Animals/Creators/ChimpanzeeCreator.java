package com.nhlstenden.WildlandsTycoon.Animals.Creators;

import com.nhlstenden.WildlandsTycoon.Animals.Species.Animal;
import com.nhlstenden.WildlandsTycoon.Animals.Species.Chimpanzee;

public class ChimpanzeeCreator extends AnimalCreator{
    @Override
    public Animal createAnimal() {
        return new Chimpanzee();
    }
}
