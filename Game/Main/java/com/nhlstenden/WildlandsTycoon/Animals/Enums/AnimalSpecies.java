package com.nhlstenden.WildlandsTycoon.Animals.Enums;

public enum AnimalSpecies {
    CHIMPANZEE("Chimpanzee", 4000),
    CROCODILE("Crocodile", 5000),
    FLAMINGO("Flamingo", 2000),
    GORILLA("Gorilla", 8000),
    HIPPO("Hippo", 7000),
    LION("Lion", 10000),
    NULL_ANIMAL("No animal", 0),
    PARROT("Parrot", 1000),
    PENGUIN("Penguin", 3000),
    RING_TAILED_LEMUR("Ring tailed Lemur", 2000),
    SNOW_LEOPARD("Snow leopard", 8000),
    TIGER("Tiger", 9000),
    TORTOISE("Tortoise", 1000);

    private String name;
    private int price;

    AnimalSpecies(String name, int price){
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice(){
        return price;
    }

    @Override
    public String toString() {
        return this.getName() + ", Price: €" + getPrice() + ",-";
    }
}
