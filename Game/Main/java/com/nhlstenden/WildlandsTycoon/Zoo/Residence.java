package com.nhlstenden.WildlandsTycoon.Zoo;

import com.nhlstenden.WildlandsTycoon.Animals.Animal;

public class Residence {

    private int ID;
    private Animal animal;

    public Residence(int ID, Animal animal) {
        this.ID = ID;
        this.animal = animal;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }
}
