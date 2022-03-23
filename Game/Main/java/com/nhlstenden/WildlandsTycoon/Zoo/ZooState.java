package com.nhlstenden.WildlandsTycoon.Zoo;

import java.sql.Time;

public class ZooState {

    //Temperature in C°
    private double temperature;

    private Time time;

    public ZooState() {
        temperature = 0;
        time = Time.valueOf("00:00:00");
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public void update(){

    }
}
