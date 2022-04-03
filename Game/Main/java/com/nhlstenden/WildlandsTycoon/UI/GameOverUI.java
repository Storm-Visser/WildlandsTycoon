package com.nhlstenden.WildlandsTycoon.UI;

import com.nhlstenden.WildlandsTycoon.Controller.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GameOverUI extends JFrame implements ActionListener{

    private Controller controller;
    private GridLayout gridLayout;

    public GameOverUI(Controller controller){
        super(controller.getZoo().getName() + " Tycoon");
        this.controller = controller;
        initialize();
    }

    /***
     * Initialization of UI
     */
    private void initialize(){
        this.setSize(300, 200);
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent){
                System.exit(0);
            }
        });

        this.gridLayout = new GridLayout(4,1);
        this.setLayout(this.gridLayout);

        JLabel headerText = new JLabel("Oh no, You ran out of money", SwingConstants.CENTER);
        headerText.setFont(new Font("Serif", Font.BOLD, 20));
        headerText.setForeground(new Color(255, 20, 20));
        this.add(headerText);

        this.add(new JLabel("You can try again next time", SwingConstants.CENTER));
        this.setVisible(true);

        JButton exitButton = new JButton("Exit");
        exitButton.addActionListener(this);
        this.add(exitButton);
        JButton retryButton = new JButton("Retry");
        retryButton.addActionListener(this);
        this.add(retryButton);

    }

    /***
     * Controls what action is performed when button is pressed
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        switch (command){
            case "Exit":
                this.dispose();
                System.exit(0);
                break;
            case "Retry":
                this.dispose();
                new StartScreenUI();
        }
    }
}
