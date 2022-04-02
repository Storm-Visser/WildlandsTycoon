package com.nhlstenden.WildlandsTycoon.Zoo;

import java.time.LocalTime;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Entrance {

    private LocalTime openingTime;
    private LocalTime closingTime;
    private double ticketPrice;
    private int amountOfGuests;
    private int totalGuestsToday;
    private int totalOutgoingMoney;
    private int totalIncomingMoney;
    private int money;
    private Queue<Integer> arrivedGuests;

    public Entrance(LocalTime openingTime, LocalTime closingTime, Double ticketPrice) {
        this.openingTime = openingTime;
        this.closingTime = closingTime;
        this.ticketPrice = ticketPrice;
        this.amountOfGuests = 0;
        this.totalGuestsToday = 0;
        this.money = 500000;
        arrivedGuests = new LinkedList<>();
    }

    public int getMoney() {
        return money;
    }

    public void removeMoney(int amount){
        this.money -= amount;
        this.totalOutgoingMoney += amount;
    }

    public void addMoney(int amount){
        this.money += amount;
        this.totalIncomingMoney += amount;
    }

    public LocalTime getOpeningTime() {
        return openingTime;
    }

    public void setOpeningTime(LocalTime openingTime) {
        this.openingTime = openingTime;
    }

    public LocalTime getClosingTime() {
        return closingTime;
    }

    public void setClosingTime(LocalTime closingTime) {
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


    public int getTotalGuestsToday() {
        return totalGuestsToday;
    }


    public void update(Zoo zoo){
        addGuests(zoo);
        removeGuests(zoo);
    }

    public void addGuests(Zoo zoo){
        if (zoo.getZooState().getTime().isBefore(LocalTime.of(this.closingTime.getHour() - 4, 0)) && zoo.getZooState().getTime().isAfter(this.openingTime)){
            Integer toAdd = Math.toIntExact(Math.round(zoo.getAppeal() / 10));
            this.amountOfGuests += toAdd;
            this.totalGuestsToday += toAdd;
            this.arrivedGuests.add(toAdd);
            this.addMoney(toAdd);
        }
    }

    public void removeGuests(Zoo zoo){
        if (zoo.getZooState().getTime().isAfter(LocalTime.of(this.openingTime.getHour() - 4, 0)) && this.arrivedGuests.size() > 0){
            this.amountOfGuests -= this.arrivedGuests.remove();
        }
    }
    //ToDo method voor toevoegen van gasten A.D.H.V appeal en prijs
    //ToDo update met de prijs/money
}
