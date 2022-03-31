package com.nhlstenden.WildlandsTycoon.Controller;

import com.nhlstenden.WildlandsTycoon.UI.GameUI;
import com.nhlstenden.WildlandsTycoon.Zoo.Zoo;

import java.time.LocalTime;
import java.util.Timer;
import java.util.TimerTask;


public class Controller {

    private Zoo zoo;
    private Timer timer;
    private GameUI gameUI;

    public Controller(Zoo zoo) {
        this.zoo = zoo;
    }

    public void initialize(){
        this.timer = new Timer();
        //set een TimerTask die de update functie aanroept om de 1sec
        timer.schedule(new simpleTask(), 1000, 1000);
    }

    public void setGameUI(GameUI gameUI) {
        this.gameUI = gameUI;
    }

    public Zoo getZoo() {
        return zoo;
    }

    public void update(){
        zoo.update();
        if (zoo.getZooState().getTime().equals(LocalTime.of(0,0))){
            System.out.println("Day passed");
            //ToDo means the day passed, do the memento things
        }
        this.gameUI.updateUI();
    }

    private class simpleTask extends TimerTask{
        public void run() {
            update();
        }
    }
}
