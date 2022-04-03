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
        this.money = 50000;
        arrivedGuests = new LinkedList<>();
    }

    public int getMoney() {
        return money;
    }

    /***
     * Removes money
     * @param amount
     */
    public void removeMoney(int amount){
        this.money -= amount;
        this.totalOutgoingMoney += amount;
    }

    /***
     * Adds money
     * @param amount
     */
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

    /***
     * Voegt gasten toe aan de hand van het huidige appeal en de ticketprijs
     * @param zoo De dierentuin
     */
    public void addGuests(Zoo zoo){
        if (zoo.getZooState().getTime().isBefore(LocalTime.of(this.closingTime.getHour() - 4, 0)) && zoo.getZooState().getTime().isAfter(this.openingTime)){
            int maxToAdd = (int) (Math.round(zoo.getAppeal() / 6));
            int toAdd = getAmountOfGuestsToAddAfterPrice(maxToAdd, zoo.getAppeal());
            this.amountOfGuests += toAdd;
            this.totalGuestsToday += toAdd;
            this.arrivedGuests.add(toAdd);
            this.addMoney((int) (Math.round(toAdd * ticketPrice)));
        }
    }

    /***
     * Berekend het aantal gasten dat wil komen nadat de prijs is meegenomen
     * Dit gaat aan de hand van een maximumprijs die de gasten willen betalen voor de appeal
     * als de prijs hoger is dan de maximumprijs voor de gasten, komen er minder gasten aan de hand van het verschil
     * Als de prijs 10 euro duurder is dan de maximumprijs voor de gasten, komen er geen gasten
     * @param maxToAdd Het aantal gasten om toe te voegen (die willen komen)
     * @param appeal De appeal van de zoo
     * @return Het aantal gasten dat komt nadat ze de prijs hebben gezien
     */
    private int getAmountOfGuestsToAddAfterPrice(int maxToAdd, double appeal){
        double appealFactor = 5 + (0.036 * appeal);
        if (appealFactor < this.ticketPrice){
            double diff = ticketPrice - appealFactor;
            if (diff > 10){
                maxToAdd = 0;
            } else {
                maxToAdd = (int) Math.round(maxToAdd / (diff + 1));
            }
            System.out.println("price too high");
        }
        return Math.max(maxToAdd, 0);
    }

    /***
     * Haalt gasten weg die 4 uur geleden zijn binnengekomen
     * @param zoo De dierentuin
     */
    public void removeGuests(Zoo zoo){
        if (this.arrivedGuests.size() > 0){
            if (zoo.getZooState().getTime().isAfter(LocalTime.of(this.openingTime.getHour() + 4, 0))){
                if (zoo.getZooState().getTime().isAfter(LocalTime.of(this.closingTime.getHour() - 4, 0))){
                    this.amountOfGuests -= this.arrivedGuests.remove();
                } else if(this.arrivedGuests.size() > 24) {
                    this.amountOfGuests -= this.arrivedGuests.remove();
                }
            }
        }
    }
}
