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
    private JLabel firstLabel;
    private JLabel secondLabel;
    private JLabel thirdLabel;
    private JLabel fourthLabel;
    private ArrayList<ZooMemento> mementos;


    public FinancesUI(Controller controller, ArrayList<ZooMemento> mementos) throws HeadlessException {
        super("Finances");
        this.controller = controller;
        this.mementos = mementos;
        this.initialize();
    }

    private void initialize(){
        this.setSize(600, 200);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //show the memento's
        this.setLayout(new GridLayout(5,1));

        this.firstLabel = new JLabel();
        this.secondLabel = new JLabel();
        this.thirdLabel = new JLabel();
        this.fourthLabel = new JLabel();

        String guestsText = "Gasten vandaag: ";
        String residenceText = " Aantal verblijven: ";
        String priceText = " Entreeprijs: ";


        if(mementos.size() > 0){
            this.firstLabel.setText(guestsText +  + mementos.get(mementos.size() - 1).getGuests() + residenceText + mementos.get(mementos.size() - 1).getResidenceAmount() + priceText + mementos.get(mementos.size() - 1).getTicketPrice());
        }
        if(mementos.size() > 1){
            this.secondLabel.setText(guestsText +  + mementos.get(mementos.size() - 2).getGuests() + residenceText + mementos.get(mementos.size() - 2).getResidenceAmount() + priceText + mementos.get(mementos.size() - 2).getTicketPrice());
        }
        if (mementos.size() > 2){
            this.thirdLabel.setText(guestsText +  + mementos.get(mementos.size() - 3).getGuests() + residenceText + mementos.get(mementos.size() - 3).getResidenceAmount() + priceText + mementos.get(mementos.size() - 3).getTicketPrice());
        }
        if(mementos.size() > 3){
            this.fourthLabel.setText(guestsText +  + mementos.get(mementos.size() - 4).getGuests() + residenceText + mementos.get(mementos.size() - 4).getResidenceAmount() + priceText + mementos.get(mementos.size() - 4).getTicketPrice());
        }

        this.add(firstLabel);
        this.add(secondLabel);
        this.add(thirdLabel);
        this.add(fourthLabel);

        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}