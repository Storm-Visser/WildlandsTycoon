package com.nhlstenden.WildlandsTycoon.UI;

import com.nhlstenden.WildlandsTycoon.Controller.Controller;
import com.nhlstenden.WildlandsTycoon.Zoo.Zoo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Time;
import java.time.LocalTime;

public class StartScreenUI implements ActionListener {

    private Controller controller;

    private JFrame mainFrame;

    private JTextField textField;

    private GridLayout gridLayout;

    public static void main(String[] args) {
        new StartScreenUI();
    }

    public StartScreenUI(){
        createGUI();
    }

    private void createGUI(){
        mainFrame = new JFrame("Create Zoo");
        mainFrame.setSize(300,150);
        mainFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent){
                System.exit(0);
            }
        });
        this.gridLayout = new GridLayout(3, 1);
        mainFrame.setLayout(this.gridLayout);

        mainFrame.add(new JLabel("Enter zoo name:"));

        this.textField = new JTextField();
        mainFrame.add(this.textField);

        JButton doneButton = new JButton("Start zoo");
        doneButton.addActionListener(this);
        mainFrame.add(doneButton);

        mainFrame.setVisible(true);

    }



    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        if (command.equals("Start zoo")){
            System.out.println("Creating zoo");
            String selected = textField.getText();
            createNewZoo(selected);
            new GameUI(controller);
            mainFrame.setVisible(false);
        }
    }

    public void createNewZoo(String selectedName){
        //get this from ui
        String name = selectedName;
        String location = "Emmen";
        LocalTime openingTime = LocalTime.of(6,0);
        LocalTime closingTime = LocalTime.of(20,0);
        Double price = 5.0;
        int width = 5;
        int height = 5;

        Zoo zoo = new Zoo(name, location, openingTime, closingTime, price, width, height);
        this.controller = new Controller(zoo);
        this.controller.initialize();
    }
}
