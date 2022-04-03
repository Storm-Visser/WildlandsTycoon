package com.nhlstenden.WildlandsTycoon.Zoo;

import java.time.LocalTime;
import java.util.Random;

public class ZooState {

    //Temperature in C°
    private int temperature;

    private LocalTime time;

    public ZooState() {
        temperature = 20;
        time = LocalTime.of(23,30);
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public LocalTime getTime() {
        return time;
    }

    public void update(){
        updateTime();
        if(this.time.getMinute() == 0){
            updateTemperature();
        }
    }

    private void updateTime(){
        this.time = this.time.plusMinutes(10);
    }

    public void updateTemperature(){
        if(time.getHour() >= 0 && time.getHour() < 6){
            this.temperature = new Random().nextInt(15 - 10) + 10;
        }
        else if(time.getHour() >= 6 && time.getHour() < 13){
            this.temperature = new Random().nextInt(19 - 13) + 13;
        }
        else if (time.getHour() >= 13 && time.getHour() < 18){
            this.temperature = new Random().nextInt(23 - 19) + 19;
        }
        else if(time.getHour() >= 18 && time.getHour() <= 23){
            this.temperature = new Random().nextInt(19 - 13) + 13;
        }
        System.out.println(this.temperature);
    }
}
