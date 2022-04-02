package com.nhlstenden.WildlandsTycoon.Controller;

import com.nhlstenden.WildlandsTycoon.Controller.Memento.Caretaker;
import com.nhlstenden.WildlandsTycoon.Controller.Memento.ZooMemento;
import com.nhlstenden.WildlandsTycoon.UI.GameUI;
import com.nhlstenden.WildlandsTycoon.Zoo.Zoo;

import java.io.Console;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;


public class Controller {

    private Zoo zoo;
    private Timer timer;
    private GameUI gameUI;
    private Caretaker caretaker;

    public Controller(Zoo zoo) {
        this.zoo = zoo;
    }

    public void initialize(){
        caretaker = new Caretaker();
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
            takeSnapshot();
            System.out.println(getMementoList().get(getMementoList().size() - 1).getMemento()); // TODO Put in list instead of console line
        }
        this.gameUI.updateUI();
    }

    public void takeSnapshot(){
        caretaker.addMemento(new ZooMemento(zoo.getMoney(), zoo.getZooState().getTime()));
    }

    public ArrayList<ZooMemento> getMementoList(){
        return caretaker.getHistory();
    }

    private class simpleTask extends TimerTask{
        public void run() {
            update();
        }
    }
}
