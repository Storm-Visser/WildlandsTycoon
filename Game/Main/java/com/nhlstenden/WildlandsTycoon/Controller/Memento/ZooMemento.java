package com.nhlstenden.WildlandsTycoon.Controller.Memento;

import com.nhlstenden.WildlandsTycoon.Zoo.Residence;
import com.nhlstenden.WildlandsTycoon.Zoo.ZooState;

import java.time.LocalTime;
import java.util.ArrayList;

public class ZooMemento {

    private int totalGuestsToday;
    private int residenceAmount;
    private double ticketPrice;

    public ZooMemento(int totalGuestsToday, int residenceAmount, double ticketPrice){
        this.totalGuestsToday = totalGuestsToday;
        this.residenceAmount = residenceAmount;
        this.ticketPrice = ticketPrice;
    }

    public String getMemento(){
        return "Gasten vandaag: " + this.totalGuestsToday + " Amount of residences: " + this.residenceAmount + " ticket price: " + this.ticketPrice;
    }

    public int getGuests(){
        return this.totalGuestsToday;
    }

    public int getResidenceAmount(){
        return this.residenceAmount;
    }

    public double getTicketPrice(){
        return this.ticketPrice;
    }
}
