package com.nhlstenden.WildlandsTycoon.Controller;

import com.nhlstenden.WildlandsTycoon.Controller.Memento.Caretaker;
import com.nhlstenden.WildlandsTycoon.Controller.Memento.ZooMemento;
import com.nhlstenden.WildlandsTycoon.UI.FinancesUI;
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

    /**
     * Initializer controller
     * Sets timer that ticks every second
     */
    public void initialize(){
        caretaker = new Caretaker();
        this.timer = new Timer();
        timer.schedule(new simpleTask(), 1000, 1000);
    }

    public void setGameUI(GameUI gameUI) {
        this.gameUI = gameUI;
    }

    public Zoo getZoo() {
        return zoo;
    }

    /**
     * Updates zoo, everyday at 00:00
     */
    public void update(){
        zoo.update();
        if (zoo.getZooState().getTime().equals(LocalTime.of(0,0))){
            System.out.println("Day passed");
            takeSnapshot();
            new FinancesUI(this, getMementoList());
        }
        this.gameUI.updateUI();
        if (this.zoo.getEntrance().getMoney() < 0){
            this.gameUI.gameOver();
            this.timer.cancel();
        }
    }

    /***
     * Creates memento
     */
    public void takeSnapshot(){
        caretaker.addMemento(new ZooMemento(zoo.getEntrance().getTotalGuestsToday(), zoo.getResidenceAmount(), zoo.getEntrance().getTicketPrice()));
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
