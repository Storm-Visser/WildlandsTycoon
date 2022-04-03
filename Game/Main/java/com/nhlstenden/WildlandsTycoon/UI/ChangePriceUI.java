package com.nhlstenden.WildlandsTycoon.UI;

import com.nhlstenden.WildlandsTycoon.Controller.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChangePriceUI extends JFrame implements ActionListener{

    private Controller controller;

    private GridLayout gridLayout;

    private JSpinner priceSpinner;

    public ChangePriceUI(Controller controller){
        super("Price menu");
        this.controller = controller;
        this.initialize();
    }

    /***
     * Initialization
     */
    private void initialize(){
        this.setSize(250, 200);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.gridLayout = new GridLayout(5, 1);
        this.setLayout(this.gridLayout);
        this.add(new JLabel("Current price:"));
        this.add(new JLabel("\t" + "€" + controller.getZoo().getEntrance().getTicketPrice() + ",-"));
        this.add(new JLabel("New price:"));
        this.priceSpinner = new JSpinner(new SpinnerNumberModel(controller.getZoo().getEntrance().getTicketPrice(), 0.0, 99.0, 1.0));
        this.add(priceSpinner);
        JButton button = new JButton("Change price");
        button.addActionListener(this);
        this.add(button);
        this.setVisible(true);
    }

    /***
     * Controls what action is performed when button is pressed
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        if (command == "Change price"){
            double selected = (double) priceSpinner.getValue();
            this.controller.getZoo().getEntrance().setTicketPrice(selected);
            this.dispose();
        }
    }
}
