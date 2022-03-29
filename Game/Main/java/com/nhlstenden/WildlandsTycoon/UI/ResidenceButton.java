package com.nhlstenden.WildlandsTycoon.UI;

import com.nhlstenden.WildlandsTycoon.Animals.Species.Animal;

import javax.swing.*;

public class ResidenceButton extends JButton {

    private int id;
    private Animal animal;

    public ResidenceButton(int id, Animal animal) {
        this.id = id;
        this.animal = animal;
    }

    public int getId() {
        return id;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }
}
