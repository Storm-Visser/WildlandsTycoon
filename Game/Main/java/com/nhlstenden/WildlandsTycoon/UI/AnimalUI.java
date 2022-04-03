package com.nhlstenden.WildlandsTycoon.UI;

import com.nhlstenden.WildlandsTycoon.Animals.Creators.AnimalCreator;
import com.nhlstenden.WildlandsTycoon.Animals.Enums.AnimalSpecies;
import com.nhlstenden.WildlandsTycoon.Animals.Species.Animal;
import com.nhlstenden.WildlandsTycoon.Animals.Species.NullAnimal;
import com.nhlstenden.WildlandsTycoon.Controller.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class AnimalUI  extends JFrame implements ActionListener {

    private Controller controller;

    private Animal animal;

    private int recidenceId;

    private GridLayout gridLayout;

    private JComboBox comboBox;

    private GameUI parentGameUI;

    private boolean isRealAnimal;

    private JLabel appealValue;
    private JLabel sleepingValue;
    private JLabel stressValue;
    private JLabel fatigueValue;
    private JLabel hungerValue;
    private JLabel tempContentmentValue;
    private JButton feedBtn;

    /***
     * Constructor of AnimalUI.
     * @param controller
     * @param animal
     * @param id
     * @param gameUI
     * @throws HeadlessException
     */
    public AnimalUI(Controller controller, Animal animal, int id, GameUI gameUI) throws HeadlessException {
        super(animal.getClass().getSimpleName());
        this.controller = controller;
        this.animal = animal;
        this.recidenceId = id;
        this.parentGameUI = gameUI;
        this.initialize();
    }

    /***
     * Initializes UI elements
     */
    private void initialize(){
        if (this.animal.getClass().equals(NullAnimal.class)) {
            this.isRealAnimal = false;
            initializeNullAnimal();
        } else {
            this.isRealAnimal = true;
            this.setSize(300, 400);
            this.setLocationRelativeTo(null);
            this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
            this.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent event) {
                    closingProcedure();
                }
            });

            this.gridLayout = new GridLayout(8, 2);
            this.setLayout(this.gridLayout);

            this.add(new JLabel("Animal:", SwingConstants.CENTER));
            this.add(new JLabel(animal.getSpecies().getName()));

            this.add(new JLabel("Appeal:", SwingConstants.CENTER));
            this.appealValue = new JLabel(String.valueOf(animal.getAppeal()));
            this.add(this.appealValue);

            this.add(new JLabel("Is Sleeping?:", SwingConstants.CENTER));
            if (animal.getState().isSleeping()){
                this.sleepingValue = new JLabel("Yes, Zzz");
            } else {
                this.sleepingValue = new JLabel("No");
            }
            this.add(this.sleepingValue);

            this.add(new JLabel("Stress:", SwingConstants.CENTER));
            this.stressValue = new JLabel(String.valueOf(animal.getState().getStress()));
            this.add(this.stressValue);

            this.add(new JLabel("Fatigue:", SwingConstants.CENTER));
            this.fatigueValue = new JLabel(String.valueOf(animal.getState().getFatigue()));
            this.add(this.fatigueValue);

            this.add(new JLabel("Hunger:", SwingConstants.CENTER));
            this.hungerValue = new JLabel(String.valueOf(animal.getState().getHunger()));
            this.add(this.hungerValue);

            this.add(new JLabel("Temp Contentment:", SwingConstants.CENTER));
            this.tempContentmentValue = new JLabel(String.valueOf(animal.getState().getTemperatureContentment()));
            this.add(this.tempContentmentValue);

            this.add(new JLabel("Feed the Animal:", SwingConstants.CENTER));
            feedBtn = new JButton("Feed");
            feedBtn.addActionListener(this);
            this.add(feedBtn);

            this.createBorder();
            this.setResizable(false);
            this.setVisible(true);
        }
    }

    /***
     * Closes zoo
     */
    private void closingProcedure(){
        this.parentGameUI.removeActiveAnimalUI();
        System.out.println("closing animalUI");
        this.dispose();
    }

    /***
     * Initializes null animal
     */
    private void initializeNullAnimal(){
        this.setSize(300, 200);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent event) {
                closingProcedure();
            }
        });
        this.gridLayout = new GridLayout(4, 1);
        this.setLayout(this.gridLayout);
        this.add(new JLabel("No animal yet!!"));
        this.add(new JLabel("Select animal to add:"));
        this.comboBox = createComboBox();
        this.add(comboBox);
        JButton addButton = new JButton("Add");
        addButton.addActionListener(this);
        this.add(addButton);
        this.setResizable(false);
        this.setVisible(true);
    }

    /***
     * Controls what action is performed when button is pressed
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        if (command == "Add"){
            AnimalSpecies selected = (AnimalSpecies) comboBox.getItemAt(comboBox.getSelectedIndex());
            this.controller.getZoo().getResidence(recidenceId).addAnimal(selected);
            this.controller.getZoo().getEntrance().removeMoney(selected.getPrice());
            parentGameUI.updateUI();
            closingProcedure();
            this.dispose();
        }
        else if(command == "Feed"){
            this.controller.getZoo().getEntrance().removeMoney(this.animal.feed());
        }
    }

    /***
     * Creates color of border
     */
    private void createBorder(){
        Color color;
        switch (this.animal.getHabitat()){
            case JUNGLE:
                color = new Color(51,102,0);
                break;
            case AQUATIC:
                color = new Color(0,153,153);
                break;
            case ARCTIC:
                color = new Color(0,204,204);
                break;
            case SAVANNA:
                color = new Color(255,255,204);
                break;
            case MOUNTAIN:
                color = new Color(204,102,0);
                break;
            default:
                color = Color.red;
        }

        this.getRootPane().getContentPane().setBackground(color);
    }

    /***
     * Creates drop down menu
     * @return
     */
    private JComboBox<AnimalSpecies> createComboBox(){
        AnimalSpecies[] options = {AnimalSpecies.CHIMPANZEE, AnimalSpecies.CROCODILE, AnimalSpecies.FLAMINGO, AnimalSpecies.GORILLA, AnimalSpecies.HIPPO, AnimalSpecies.LION,
                AnimalSpecies.PARROT, AnimalSpecies.PENGUIN, AnimalSpecies.RING_TAILED_LEMUR, AnimalSpecies.SNOW_LEOPARD, AnimalSpecies.TIGER, AnimalSpecies.TORTOISE};
        JComboBox<AnimalSpecies> comboBox = new JComboBox<>(options);
        //style if necessary
        return comboBox;
    }

    /***
     * Updates UI
     */
    public void update()
    {
        if (this.isRealAnimal) {
            this.appealValue.setText(String.valueOf(animal.getAppeal()));
            if (animal.getState().isSleeping()){
                this.sleepingValue.setText("Yes, Zzz");
            } else {
                this.sleepingValue.setText("No");
            }
            this.stressValue.setText(String.valueOf(animal.getState().getStress()));
            this.fatigueValue.setText(String.valueOf(animal.getState().getFatigue()));
            this.hungerValue.setText(String.valueOf(animal.getState().getHunger()));
            this.tempContentmentValue.setText(String.valueOf(animal.getState().getTemperatureContentment()));
        }
    }
}
