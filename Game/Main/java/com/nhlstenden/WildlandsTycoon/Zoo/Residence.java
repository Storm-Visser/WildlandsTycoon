package com.nhlstenden.WildlandsTycoon.Zoo;

import com.nhlstenden.WildlandsTycoon.Animals.AnimalFactory;
import com.nhlstenden.WildlandsTycoon.Animals.Species.Animal;
import com.nhlstenden.WildlandsTycoon.Animals.Species.NullAnimal;

public class Residence {

    private int ID;
    private AnimalFactory animalFactory;
    private Animal animal;

    public Residence(int ID) {
        this.ID = ID;
        this.animalFactory = new AnimalFactory();
        this.animal = animalFactory.createNullAnimal();
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

    public void addAnimal(String animalSpecies){
        if (this.animal.getClass().equals(NullAnimal.class)){
            switch (animalSpecies) {
                case "Chimpanzee":
                    this.animal = animalFactory.createChimpanzee();
                case "Crocodile":
                    this.animal = animalFactory.createCrocodile();
                case "Flamingo":
                    this.animal = animalFactory.createFlamingo();
                case "Gorilla":
                    this.animal = animalFactory.createGorilla();
                case "Hippo":
                    this.animal = animalFactory.createHippo();
                case "Lion":
                    this.animal = animalFactory.createLion();
                case "Parrot":
                    this.animal = animalFactory.createParrot();
                case "Penguin":
                    this.animal = animalFactory.createPenguin();
                case "RingTailedLemur":
                    this.animal = animalFactory.createRingTailedLemur();
                case "SnowLeopard":
                    this.animal = animalFactory.createSnowLeopard();
                case "Tiger":
                    this.animal = animalFactory.createTiger();
                case "Tortoise":
                    this.animal = animalFactory.createTortoise();
                default:
                    System.out.println("Invalid animal species");
            }
        } else {
            System.out.println("This reecidence already contains an animal");
        }
    }
}
