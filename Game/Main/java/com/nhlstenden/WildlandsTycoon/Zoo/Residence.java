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
                    break;
                case "Crocodile":
                    this.animal = animalFactory.createCrocodile();
                    break;
                case "Flamingo":
                    this.animal = animalFactory.createFlamingo();
                    break;
                case "Gorilla":
                    this.animal = animalFactory.createGorilla();
                    break;
                case "Hippo":
                    this.animal = animalFactory.createHippo();
                    break;
                case "Lion":
                    this.animal = animalFactory.createLion();
                    break;
                case "Parrot":
                    this.animal = animalFactory.createParrot();
                    break;
                case "Penguin":
                    this.animal = animalFactory.createPenguin();
                    break;
                case "RingTailedLemur":
                    this.animal = animalFactory.createRingTailedLemur();
                    break;
                case "SnowLeopard":
                    this.animal = animalFactory.createSnowLeopard();
                    break;
                case "Tiger":
                    this.animal = animalFactory.createTiger();
                    break;
                case "Tortoise":
                    this.animal = animalFactory.createTortoise();
                    break;
                default:
                    System.out.println("Invalid animal species");
                    this.animal = animalFactory.createNullAnimal();
                    break;
            }
        } else {
            System.out.println("This residence already contains an animal");
        }
    }
}
