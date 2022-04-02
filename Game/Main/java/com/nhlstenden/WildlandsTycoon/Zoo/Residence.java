package com.nhlstenden.WildlandsTycoon.Zoo;

import com.nhlstenden.WildlandsTycoon.Animals.Creators.AnimalCreator;
import com.nhlstenden.WildlandsTycoon.Animals.Creators.NullAnimalCreator;
import com.nhlstenden.WildlandsTycoon.Animals.Enums.AnimalSpecies;
import com.nhlstenden.WildlandsTycoon.Animals.Species.Animal;
import com.nhlstenden.WildlandsTycoon.Animals.Species.NullAnimal;

public class Residence {

    private int ID;
    private Animal animal;

    public Residence(int ID) {
        this.ID = ID;
        this.animal = AnimalCreator.createAnimalBySpecies(AnimalSpecies.NULL_ANIMAL);
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

    public void addAnimal(AnimalSpecies species){
        if (this.animal.getSpecies().equals(AnimalSpecies.NULL_ANIMAL)){
            this.animal = AnimalCreator.createAnimalBySpecies(species);
        } else {
            System.out.println("This residence already contains an animal");
        }
    }
}
