package com.nhlstenden.WildlandsTycoon.Zoo;

import com.nhlstenden.WildlandsTycoon.Animals.Enums.AnimalSpecies;

import java.time.LocalTime;
import java.util.ArrayList;

public class Zoo {

    private String name;
    private String locationName;
    private ArrayList<Residence> residences;

    private Entrance entrance;
    private Grid grid;
    private ZooState zooState;


    public Zoo(String name, String locationName, LocalTime openingTime, LocalTime closingTime, Double ticketPrice, int width , int height) {
        this.name = name;
        this.locationName = locationName;
        this.residences = new ArrayList<>();
        this.entrance = new Entrance(openingTime, closingTime, ticketPrice);
        this.grid = new Grid(width, height);
        this.zooState = new ZooState();
        this.createResidences();
    }

    /***
     * Adds residences to zoo
     */
    private void createResidences(){
        for (int i = 0; i < this.grid.getWidth() * this.grid.getHeight(); i++){
            this.addResidence(new Residence(i + 1));
        }
    }

    public int getResidenceAmount(){
        int amount = 0;
        for(Residence r: residences){
            if(r.getAnimal().getSpecies() != AnimalSpecies.NULL_ANIMAL){
                amount++;
            }
        }
        return amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public Entrance getEntrance() {
        return entrance;
    }

    public void setEntrance(Entrance entrance) {
        this.entrance = entrance;
    }

    public Grid getGrid() {
        return grid;
    }

    public void setGrid(Grid grid) {
        this.grid = grid;
    }

    public ZooState getZooState() {
        return zooState;
    }

    public void setZooState(ZooState zooState) {
        this.zooState = zooState;
    }

    public void addResidence(Residence residence){
        this.residences.add(residence);
    }

    public Residence getResidence(int id){
        Residence result = null;
        for (Residence residence: this.residences) {
            if (residence.getID() == id){
                result = residence;
            }
        }
        if (result == null){
            System.out.println("no residence with id " + id);
        }
        return result;
    }

    public double getAppeal() {
        double totalAppeal = 0;
        for (Residence residence : this.residences) {
            totalAppeal += residence.getAnimal().getAppeal();
        }
        return totalAppeal;
    }

    public void update(){
        this.payBaseCosts();
        updateState();
        notifyAnimals();
        this.entrance.update(this);
    }

    public void updateState(){
        this.zooState.update();
    }

    /***
     * Keeps animal states updated every tick/second
     */
    public void notifyAnimals(){
        for (Residence residence : this.residences) {
            residence.getAnimal().update(zooState.getTemperature(), entrance.getAmountOfGuests());
        }
    }

    /***
     * Guest pays cost of zoo
     */
    private void payBaseCosts(){
        int amountOfResidences = 0;
        for (Residence residence: this.residences) {
            if (!residence.getAnimal().getSpecies().equals(AnimalSpecies.NULL_ANIMAL)){
                amountOfResidences += 1;
            }
        }
        this.entrance.removeMoney(5 * amountOfResidences);
    }
}
