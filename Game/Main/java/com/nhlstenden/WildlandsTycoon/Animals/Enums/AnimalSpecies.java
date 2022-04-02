package com.nhlstenden.WildlandsTycoon.Animals.Enums;

public enum AnimalSpecies {
    CHIMPANZEE("Chimpanzee"),
    CROCODILE("Crocodile"),
    FLAMINGO("Flamingo"),
    GORILLA("Gorilla"),
    HIPPO("Hippo"),
    LION("Lion"),
    NULL_ANIMAL("No animal"),
    PARROT("Parrot"),
    PENGUIN("Penguin"),
    RING_TAILED_LEMUR("Ring tailed Lemur"),
    SNOW_LEOPARD("Snow leopard"),
    TIGER("Tiger"),
    TORTOISE("Tortoise");

    private String name;

    AnimalSpecies(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }
    @Override
    public String toString() {
        return this.getName();
    }
}
