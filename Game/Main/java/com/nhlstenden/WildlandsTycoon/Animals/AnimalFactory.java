package com.nhlstenden.WildlandsTycoon.Animals;

import com.nhlstenden.WildlandsTycoon.Animals.Species.*;
import com.nhlstenden.WildlandsTycoon.Animals.Species.Animal;

public class AnimalFactory {

    public Animal createNullAnimal() {
        return new NullAnimal();
    }

    public Animal createFlamingo() {
        return new Flamingo();
    }

    public Animal createParrot() {
        return new Parrot();
    }

    public Animal createPenguin() {
        return new Penguin();
    }

    public Animal createGorilla() {
        return new Gorilla();
    }

    public Animal createRingTailedLemur() {
        return new RingTailedLemur();
    }

    public Animal createChimpanzee() {
        return new Chimpanzee();
    }

    public Animal createLion() {
        return new Lion();
    }

    public Animal createSnowLeopard() {
        return new SnowLeopard();
    }

    public Animal createTiger() {
        return new Tiger();
    }

    public Animal createHippo() {
        return new Hippo();
    }

    public Animal createTortoise() {
        return new Tortoise();
    }

    public Animal createCrocodile() {
        return new Crocodile();
    }

}
