package com.nhlstenden.WildlandsTycoon.UI;

import com.nhlstenden.WildlandsTycoon.Animals.Species.Animal;
import com.nhlstenden.WildlandsTycoon.Animals.Species.NullAnimal;
import com.nhlstenden.WildlandsTycoon.Controller.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AnimalUI  extends JFrame implements ActionListener {

    private Controller controller;

    private Animal animal;

    private int recidenceId;

    private GridLayout gridLayout;

    private JComboBox comboBox;

    private GameUI parentGameUI;

    public AnimalUI(Controller controller, Animal animal, int id, GameUI gameUI) throws HeadlessException {
        super(animal.getClass().getSimpleName());
        this.controller = controller;
        this.animal = animal;
        this.recidenceId = id;
        this.parentGameUI = gameUI;
        this.initialize();
    }

    private void initialize(){
        if (this.animal.getClass().equals(NullAnimal.class)) {
            initializeNullAnimal();
        } else {
            this.setSize(300, 400);
            this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            this.gridLayout = new GridLayout(8, 2);
            this.setLayout(this.gridLayout);

            this.add(new JLabel("Animal:"));
            this.add(new JLabel(animal.getClass().getSimpleName()));

            this.add(new JLabel("Appeal:"));
            this.add(new JLabel(String.valueOf(animal.getAppeal())));

            this.add(new JLabel("Is Sleeping?:"));
            if (animal.getState().isSleeping()){
                this.add(new JLabel("Yes, Zzz"));
            } else {
                this.add(new JLabel("No"));
            }

            this.add(new JLabel("Stress:"));
            this.add(new JLabel(String.valueOf(animal.getState().getStress())));

            this.add(new JLabel("Fatigue:"));
            this.add(new JLabel(String.valueOf(animal.getState().getFatigue())));

            this.add(new JLabel("Hunger:"));
            this.add(new JLabel(String.valueOf(animal.getState().getHunger())));

            this.add(new JLabel("Temp Contentment:"));
            this.add(new JLabel(String.valueOf(animal.getState().getTemperatureContentment())));

            this.setVisible(true);
        }
    }

    private void initializeNullAnimal(){
        this.setSize(300, 200);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.gridLayout = new GridLayout(2, 1);
        this.setLayout(this.gridLayout);
        this.add(new JLabel("No animal yet!!"));
        this.add(new JLabel("Select animal to add"));
        this.comboBox = createComboBox();
        this.add(comboBox);
        JButton addButton = new JButton("Add");
        addButton.addActionListener(this);
        this.add(addButton);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        if (command == "Add"){
            String selected = (String) comboBox.getItemAt(comboBox.getSelectedIndex());
            this.controller.getZoo().getResidence(recidenceId).addAnimal(selected);
            parentGameUI.updateUI();
            this.dispose();
        }
    }

    private JComboBox<String> createComboBox(){
        String[] options = {"Chimpanzee", "Crocodile", "Flamingo", "Gorilla", "Hippo", "Lion", "Parrot", "Penguin", "Ring tailed Lemur", "Snow Leopard", "Tiger", "Tortoise"};
        JComboBox<String> comboBox = new JComboBox<>(options);
        //style if necessary
        return comboBox;
    }
}
