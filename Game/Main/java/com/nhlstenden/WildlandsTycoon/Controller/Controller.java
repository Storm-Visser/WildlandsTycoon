package com.nhlstenden.WildlandsTycoon.Controller;

import com.nhlstenden.WildlandsTycoon.Zoo.Zoo;

import java.util.Timer;
import java.util.TimerTask;


public class Controller {

    private Zoo zoo;
    private Timer timer;

    public Controller(Zoo zoo) {
        this.zoo = zoo;
    }

    public void initialize(){
        this.timer = new Timer();
        //set een TimerTask die de update functie aanroept om de 1sec
        timer.schedule(new simpleTask(), 1000, 1000);
    }

    public Zoo getZoo() {
        return zoo;
    }

    public void update(){
        zoo.update();
    }

    private class simpleTask extends TimerTask{
        public void run() {
            update();
        }
    }
}
