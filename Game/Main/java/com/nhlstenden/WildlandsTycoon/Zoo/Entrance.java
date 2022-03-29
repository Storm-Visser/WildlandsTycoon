package com.nhlstenden.WildlandsTycoon.Zoo;

import java.sql.Time;

public class Entrance {

    private Time openingTime;
    private Time closingTime;
    private double ticketPrice;
    private int amountOfGuests;
    private int totalGuestsToday;

    public Entrance(Time openingTime, Time closingTime, Double ticketPrice) {
        this.openingTime = openingTime;
        this.closingTime = closingTime;
        this.ticketPrice = ticketPrice;
        this.amountOfGuests = 0;
        this.totalGuestsToday = 0;
    }

    public Time getOpeningTime() {
        return openingTime;
    }

    public void setOpeningTime(Time openingTime) {
        this.openingTime = openingTime;
    }

    public Time getClosingTime() {
        return closingTime;
    }

    public void setClosingTime(Time closingTime) {
        this.closingTime = closingTime;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public int getAmountOfGuests() {
        return amountOfGuests;
    }

    public void setAmountOfGuests(int amountOfGuests) {
        this.amountOfGuests = amountOfGuests;
    }

    public int getTotalGuestsToday() {
        return totalGuestsToday;
    }

    public void setTotalGuestsToday(int totalGuestsToday) {
        this.totalGuestsToday = totalGuestsToday;
    }
}
