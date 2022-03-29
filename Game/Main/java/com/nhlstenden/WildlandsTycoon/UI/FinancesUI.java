package com.nhlstenden.WildlandsTycoon.UI;

import com.nhlstenden.WildlandsTycoon.Controller.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FinancesUI  extends JFrame implements ActionListener {

    private Controller controller;

    private GridLayout gridLayout;

    public FinancesUI(Controller controller) throws HeadlessException {
        super("Finances");
        this.controller = controller;
        this.initialize();
    }

    private void initialize(){
        this.setSize(400, 200);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //show the memento's
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}