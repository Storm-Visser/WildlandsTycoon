package com.nhlstenden.WildlandsTycoon.UI;

import com.nhlstenden.WildlandsTycoon.Controller.Controller;
import com.nhlstenden.WildlandsTycoon.Controller.Memento.ZooMemento;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class FinancesUI  extends JFrame implements ActionListener {

    private Controller controller;

    private GridLayout gridLayout;
    private JLabel guestsLabel;
    private JLabel residenceLabel;
    private JLabel priceLabel;
    private ArrayList<ZooMemento> mementos;


    public FinancesUI(Controller controller, ArrayList<ZooMemento> mementos) throws HeadlessException {
        super("Finances");
        this.controller = controller;
        this.mementos = mementos;
        this.initialize();
    }

    private void initialize(){
        this.setSize(400, 200);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //show the memento's
        this.setLayout(new GridLayout(1,3));

        this.guestsLabel = new JLabel();
        this.residenceLabel = new JLabel();
        this.priceLabel = new JLabel();
        if(mementos.size() > 0){
            this.priceLabel.setText("Gasten vandaag: " + mementos.get(mementos.size() - 1).getGuests());
            this.residenceLabel.setText("Aantal verblijven: " + mementos.get(mementos.size() - 1).getResidenceAmount());
            this.priceLabel.setText("Entreeprijs: " + mementos.get(mementos.size() - 1).getTicketPrice());
        }
        this.add(guestsLabel);
        this.add(residenceLabel);
        this.add(priceLabel);

        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}