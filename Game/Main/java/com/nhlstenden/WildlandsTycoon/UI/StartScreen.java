package com.nhlstenden.WildlandsTycoon.UI;

import com.nhlstenden.WildlandsTycoon.Controller.Controller;
import com.nhlstenden.WildlandsTycoon.Zoo.Zoo;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Time;

public class StartScreen implements ActionListener {

    private Controller controller;

    private JFrame mainFrame;
    private JPanel panel;
    private JButton doneButton;

    public static void main(String[] args) {
        StartScreen startScreen = new StartScreen();
    }

    public StartScreen(){
        createGUI();
    }

    private void createGUI(){
        mainFrame = new JFrame("Create Zoo");
        mainFrame.setSize(1000,1000);
        // GridLayout voor de layout
        mainFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent){
                System.exit(0);
            }
        });
        panel = new JPanel();

        doneButton = new JButton("Done");
        doneButton.addActionListener(this);
        panel.add(doneButton);
        mainFrame.add(panel);
        mainFrame.setVisible(true);
        mainFrame.setVisible(true);
    }



    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        if (command.equals("Done")){
            System.out.println("Creating zoo");
            createNewZoo();
            System.out.println("Created zoo");
        }
    }

    public void createNewZoo(){
        String name = "";
        String location = "";
        Time openingTime = Time.valueOf("09:00:00");
        Time closingTime = Time.valueOf("18:00:00");
        Double price = 5.0;
        int width = 5;
        int height = 5;
        Zoo zoo = new Zoo(name, location, openingTime, closingTime, price, width, height);
        this.controller = new Controller(zoo);
        this.controller.initialize();
    }
}
