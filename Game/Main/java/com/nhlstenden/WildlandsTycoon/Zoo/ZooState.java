package com.nhlstenden.WildlandsTycoon.Zoo;

import java.time.LocalTime;

public class ZooState {

    //Temperature in C°
    private double temperature;

    private LocalTime time;

    public ZooState() {
        temperature = 20;
        time = LocalTime.of(23,30);
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public LocalTime getTime() {
        return time;
    }

    public void update(){
        updateTime();
        updateTemperature();
    }

    private void updateTime(){
        this.time = this.time.plusMinutes(10);
    }

    public void updateTemperature(){
        //ToDo some algorithm to control temp according to time
    }
}
