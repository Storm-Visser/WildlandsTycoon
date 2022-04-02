package com.nhlstenden.WildlandsTycoon.UI;

import com.nhlstenden.WildlandsTycoon.Controller.Controller;
import com.nhlstenden.WildlandsTycoon.Zoo.Zoo;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
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

        Splash();
        createGUI();
    }


    public void Splash()
    {
        SplashScreenUI splash = new SplashScreenUI();
    }
    private void createGUI(){
        mainFrame = new JFrame("Create Zoo");
        mainFrame.setSize(800,600);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.getContentPane().setBackground(Color.GRAY);
        mainFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent){
                System.exit(0);
            }
        });
        mainFrame.setLayout(null);

        JLabel label = new JLabel("Enter zoo name:");
        label.setBounds(200,60,600,200);
        label.setFont(new Font("Calibri", Font.BOLD, 60));
        mainFrame.add(label);

        this.textField = new JTextField();
        textField.setBounds(250,250,300,40);
        mainFrame.add(textField, BorderLayout.CENTER);
        JButton doneButton = new JButton("Start zoo");
        doneButton.addActionListener(this);
        doneButton.setBounds(250, 300, 300, 40);
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
