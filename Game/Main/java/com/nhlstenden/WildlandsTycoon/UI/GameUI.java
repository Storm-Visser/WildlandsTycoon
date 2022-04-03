package com.nhlstenden.WildlandsTycoon.UI;

import com.nhlstenden.WildlandsTycoon.Animals.Species.Animal;
import com.nhlstenden.WildlandsTycoon.Animals.Species.NullAnimal;
import com.nhlstenden.WildlandsTycoon.Controller.Controller;
import com.nhlstenden.WildlandsTycoon.Controller.Memento.ZooMemento;
import com.nhlstenden.WildlandsTycoon.Zoo.Residence;

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
    private JMenuItem amountOfGuests;

    private ArrayList<ResidenceButton> residenceButtons;

    private ArrayList<ResidenceBody> residencesbodys;

    private GridLayout gridLayout;

    private AnimalUI activeAnimalUI;



    public GameUI(Controller controller){
        super(controller.getZoo().getName() + " Tycoon");
        this.controller = controller;
        controller.setGameUI(this);
        this.residenceButtons = new ArrayList<>();
        this.residencesbodys = new ArrayList<>();
        this.activeAnimalUI = null;
        initialize();
    }

    public void removeActiveAnimalUI(){
        this.activeAnimalUI = null;
    }

    public Controller getController() {
        return controller;
    }

    /***
     * Initialization of UI
     */
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
        this.addResidencesBodys();
        this.addResidences();
        this.setVisible(true);
    }

    /***
     * Creates navigation bar
     * @return
     */
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
        this.temperature = new JMenuItem(controller.getZoo().getZooState().getTemperature() + "°C");
        this.amountOfGuests = new JMenuItem(controller.getZoo().getEntrance().getAmountOfGuests() + " Guests");
        //add menu to menubar
        this.menuBar.add(entranceMenu);
        menuBar.add(Box.createHorizontalGlue());
        this.menuBar.add(this.money);
        this.menuBar.add(this.amountOfGuests);
        this.menuBar.add(this.temperature);
        this.menuBar.add(this.time);
        return this.menuBar;
    }

    /***
     * Controls what action is performed when button is pressed
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        switch (command){
            case "Change price":
                this.createPriceWindow();
                break;
            case "Show finances":
                this.createFinancesWindow(this.controller.getMementoList());
                break;
            default:
                ResidenceButton src = (ResidenceButton) e.getSource();
                this.createAnimalUI(src.getAnimal(), src.getId());
        }
    }

    private void createPriceWindow(){
        new ChangePriceUI(controller);
    }

    private void createFinancesWindow(ArrayList<ZooMemento> mementos){
        new FinancesUI(controller, mementos);
    }

    private void createAnimalUI(Animal animal, int id){
        this.activeAnimalUI = new AnimalUI(this.controller, animal, id, this);
    }

    /***
     * Creates bodies of residences
     */
    private void addResidencesBodys()
    {
        for (int i = 1; i <= controller.getZoo().getGrid().getWidth() * controller.getZoo().getGrid().getHeight(); i++) {
            ResidenceBody residenceBody = new ResidenceBody(i);
            residenceBody.setBorder(BorderFactory.createMatteBorder(10,10,10,10, Color.GRAY));
            this.residencesbodys.add(residenceBody);
            residenceBody.setLayout(null);
            this.add(residenceBody);
        }
    }

    /***
     * Adds new residences to body
     */
    private void addResidences(){
        for (int i = 1; i <= residencesbodys.size(); i++){
           ResidenceBody residence = residencesbodys.get(i - 1);
            ResidenceButton residenceButton = new ResidenceButton(i, controller.getZoo().getResidence(i).getAnimal());
            residenceButton.setText(controller.getZoo().getResidence(i).getAnimal().getSpecies().getName());
            residenceButton.setBounds(40, 60, 120, 60);
            residenceButton.addActionListener(this);
            this.residenceButtons.add(residenceButton);
            residence.add(residenceButton);
        }
    }

    /***
     * Updates UI when changes are made
     */
    public void updateUI(){
        for (int i = 1; i <= residenceButtons.size(); i++) {
            ResidenceButton residenceButton = residenceButtons.get(i - 1);
            residenceButton.setText(controller.getZoo().getResidence(i).getAnimal().getSpecies().getName());
            residenceButton.setAnimal(controller.getZoo().getResidence(i).getAnimal());
        }
        if (Integer.parseInt(this.money.getText().substring(1, this.money.getText().length() - 2)) < this.controller.getZoo().getEntrance().getMoney()) {
            this.money.setForeground(new Color(0,150, 0));
        } else if (Integer.parseInt(this.money.getText().substring(1, this.money.getText().length() - 2)) > this.controller.getZoo().getEntrance().getMoney()) {
            this.money.setForeground(new Color(150,0, 0));
        } else {
            this.money.setForeground(Color.black);
        }
        this.money.setText("€" + this.controller.getZoo().getEntrance().getMoney() + ",-");
        this.time.setText(this.controller.getZoo().getZooState().getTime().toString());
        this.temperature.setText(this.controller.getZoo().getZooState().getTemperature() + "°C");
        this.amountOfGuests.setText(controller.getZoo().getEntrance().getAmountOfGuests() + " Guests");
        if (this.activeAnimalUI != null){
            this.activeAnimalUI.update();
        }
        changeColoursAnimal();
        changeColoursResidence();
    }

    /***
     * Changes colours based on appeal percentage
     */
    private void changeColoursAnimal(){
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

    /***
     * Changes colours based on habitat
     */
    private void changeColoursResidence() {
        for (int i = 1; i <= residenceButtons.size(); i++) {
            if (!controller.getZoo().getResidence(i).getAnimal().getClass().equals(NullAnimal.class)) {
                ResidenceButton residenceButton = residenceButtons.get(i - 1);
                ResidenceBody residence = residencesbodys.get(i - 1);
                Color color;
                switch (residenceButton.getAnimal().getHabitat()) {
                    case JUNGLE:
                        color = new Color(51, 102, 0);
                        break;
                    case AQUATIC:
                        color = new Color(0, 153, 153);
                        break;
                    case ARCTIC:
                        color = new Color(0, 204, 204);
                        break;
                    case SAVANNA:
                        color = new Color(255, 255, 204);
                        break;
                    case MOUNTAIN:
                        color = new Color(204, 102, 0);
                        break;
                    default:
                        color = Color.white;
                }
                residence.setBackground(color);
            }
        }
    }

    /***
     * Creates game over UI
     */
    public void gameOver(){
        new GameOverUI(controller);
        this.dispose();
    }
}
