package com.nhlstenden.WildlandsTycoon.UI;

import com.nhlstenden.WildlandsTycoon.Animals.Species.Animal;
import com.nhlstenden.WildlandsTycoon.Animals.Species.NullAnimal;
import com.nhlstenden.WildlandsTycoon.Controller.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.time.LocalTime;
import java.util.ArrayList;

public class GameUI extends JFrame implements ActionListener {

    private Controller controller;

    private JMenuBar menuBar;
    private JMenu entranceMenu;
    private JMenuItem changePriceItem;
    private JMenuItem showFinancesItem;

    private JMenuItem money;
    private JMenuItem time;
    private JMenuItem temperature;


    private ArrayList<ResidenceButton> residenceButtons;

    private GridLayout gridLayout;

    private AnimalUI activeAnimalUI;



    public GameUI(Controller controller){
        super(controller.getZoo().getName() + " Tycoon");
        this.controller = controller;
        controller.setGameUI(this);
        this.residenceButtons = new ArrayList<>();
        this.activeAnimalUI = null;
        initialize();
    }

    public void removeActiveAnimalUI(){
        this.activeAnimalUI = null;
    }

    public Controller getController() {
        return controller;
    }

    private void initialize(){
        this.setSize(1000, 1000);
        this.setLocationRelativeTo(null);
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent){
                System.exit(0);
            }
        });
        this.setJMenuBar(this.createMenu());
        this.gridLayout = new GridLayout(controller.getZoo().getGrid().getHeight(), controller.getZoo().getGrid().getWidth());
        this.setLayout(this.gridLayout);
        this.addResidences();
        this.setVisible(true);
    }

    private JMenuBar createMenu(){
        //menubar
        this.menuBar = new JMenuBar();
        //menu
        this.entranceMenu= new JMenu("Entrance");
        //items
        this.changePriceItem = new JMenuItem("Change price");
        this.changePriceItem.addActionListener(this);

        this.showFinancesItem = new JMenuItem("Show finances");
        this.showFinancesItem.addActionListener(this);
        //add items to menu
        this.entranceMenu.add(this.changePriceItem);
        this.entranceMenu.add(this.showFinancesItem);
        //menu
        this.money = new JMenuItem("€" + controller.getZoo().getEntrance().getMoney() + ",-");
        //menu
        this.time = new JMenuItem(controller.getZoo().getZooState().getTime().toString());
        this.temperature = new JMenuItem(String.valueOf(controller.getZoo().getZooState().getTemperature()));
        //add menu to menubar
        this.menuBar.add(entranceMenu);
        menuBar.add(Box.createHorizontalGlue());
        this.menuBar.add(this.money);
        this.menuBar.add(this.time);
        this.menuBar.add(this.temperature);
        return this.menuBar;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        switch (command){
            case "Change price":
                this.createPriceWindow();
                break;
            case "Show finances":
                this.createFinancesWindow();
                break;
            default:
                ResidenceButton src = (ResidenceButton) e.getSource();
                this.createAnimalUI(src.getAnimal(), src.getId());
                System.out.println("dadsa");
        }
    }

    private void createPriceWindow(){
        new ChangePriceUI(controller);
    }

    private void createFinancesWindow(){
        new FinancesUI(controller);
    }

    private void createAnimalUI(Animal animal, int id){
        //ToDo Foto/graphics voor de animals
        this.activeAnimalUI = new AnimalUI(this.controller, animal, id, this);
    }

    private void addResidences(){
        for (int i = 1; i <= controller.getZoo().getGrid().getWidth() * controller.getZoo().getGrid().getHeight(); i++){
            ResidenceButton residenceButton = new ResidenceButton(i, controller.getZoo().getResidence(i).getAnimal());
            residenceButton.setText(controller.getZoo().getResidence(i).getAnimal().getSpecies().getName());
            residenceButton.addActionListener(this);
            this.residenceButtons.add(residenceButton);
            this.add(residenceButton);
        }
    }

    public void updateUI(){
        for (int i = 1; i <= residenceButtons.size(); i++) {
            ResidenceButton residenceButton = residenceButtons.get(i - 1);
            residenceButton.setText(controller.getZoo().getResidence(i).getAnimal().getSpecies().getName());
            residenceButton.setAnimal(controller.getZoo().getResidence(i).getAnimal());
        }
        this.money.setText("€" + this.controller.getZoo().getEntrance().getMoney() + ",-");
        this.time.setText(this.controller.getZoo().getZooState().getTime().toString());
        this.temperature.setText(String.valueOf(this.controller.getZoo().getZooState().getTemperature()));
        if (this.activeAnimalUI != null){
            this.activeAnimalUI.update();
        }
        changeColours();
    }

    private void changeColours(){
        for (int i = 1; i <= residenceButtons.size(); i++) {
            if (!controller.getZoo().getResidence(i).getAnimal().getClass().equals(NullAnimal.class)) {
                ResidenceButton residenceButton = residenceButtons.get(i - 1);
                double maxAppeal = residenceButton.getAnimal().getBaseAppeal();
                double currentAppeal = residenceButton.getAnimal().getAppeal();
                double percentageAppeal = currentAppeal / maxAppeal;
                float redValue = (float) (1 - percentageAppeal);
                float greenValue = (float) percentageAppeal;
                residenceButton.setBackground(new Color(redValue, greenValue, 0));
            }
        }
    }

    public void gameOver(){
        new GameOverUI(controller);
        this.dispose();
    }
}
