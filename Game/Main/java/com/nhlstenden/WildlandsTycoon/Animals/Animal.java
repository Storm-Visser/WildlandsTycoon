package com.nhlstenden.WildlandsTycoon.Animals;

public class Animal {

    private Double dailyHoursOfSleep;
    //Temperature in C°
    private Double maxTemperature;
    private Double minTempreature;

    private Habitat habitat;
    private State state;

    public Animal(Double dailyHoursOfSleep, Double maxTemperature, Double minTempreature, Habitat habitat, State state) {
        this.dailyHoursOfSleep = dailyHoursOfSleep;
        this.maxTemperature = maxTemperature;
        this.minTempreature = minTempreature;
        this.habitat = habitat;
        this.state = state;
    }

    public Double getDailyHoursOfSleep() {
        return dailyHoursOfSleep;
    }

    public void setDailyHoursOfSleep(Double dailyHoursOfSleep) {
        this.dailyHoursOfSleep = dailyHoursOfSleep;
    }

    public Double getMaxTemperature() {
        return maxTemperature;
    }

    public void setMaxTemperature(Double maxTemperature) {
        this.maxTemperature = maxTemperature;
    }

    public Double getMinTemperature() {
        return minTempreature;
    }

    public void setMinTemperature(Double minTemperature) {
        this.minTempreature = minTemperature;
    }

    public Habitat getHabitat() {
        return habitat;
    }

    public void setHabitat(Habitat habitat) {
        this.habitat = habitat;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public double GetAppeal() {
        double appeal;
        appeal = 0;
        return  appeal;
    }

    public void UpdateState() {

    }

    public void Update() {

    }
}
