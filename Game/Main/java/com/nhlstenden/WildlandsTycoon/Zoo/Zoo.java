package com.nhlstenden.WildlandsTycoon.Zoo;

import com.nhlstenden.WildlandsTycoon.Animals.Animal;
import com.nhlstenden.WildlandsTycoon.Animals.Habitat;
import com.nhlstenden.WildlandsTycoon.Animals.State;

import java.sql.Time;
import java.util.ArrayList;

public class Zoo {

    private String name;
    private String locationName;
    private ArrayList<Residence> residences;

    private Entrance entrance;
    private Grid grid;
    private ZooState zooState;

    public Zoo(String name, String locationName, Time openingTime, Time closingTime, Double ticketPrice, int width , int height) {
        this.name = name;
        this.locationName = locationName;
        this.residences = new ArrayList<>();
        this.entrance = new Entrance(openingTime, closingTime, ticketPrice);
        this.grid = new Grid(width, height);
        this.zooState = new ZooState();
        this.addResidence(new Residence(1, new Animal(3.0, 30.0, 20.0, Habitat.AQUATIC, new State())));
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

    public double getAppeal() {
        double totalAppeal = 0;
        for (Residence residence : this.residences) {
            totalAppeal += residence.getAnimal().getAppeal();
        }
        return totalAppeal;
    }

    public void update(){
        updateState();
        notifyAnimals();
    }
    public void updateState(){
        this.zooState.update();
    }

    public void notifyAnimals(){
        for (Residence residence : this.residences) {
            residence.getAnimal().update(zooState.getTemperature(), entrance.getAmountOfGuests());
        }
    }
}
