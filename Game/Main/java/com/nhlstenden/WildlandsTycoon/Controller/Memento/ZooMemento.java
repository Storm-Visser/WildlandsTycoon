package com.nhlstenden.WildlandsTycoon.Controller.Memento;

import com.nhlstenden.WildlandsTycoon.Zoo.Residence;
import com.nhlstenden.WildlandsTycoon.Zoo.ZooState;

import java.time.LocalTime;
import java.util.ArrayList;

public class ZooMemento {

    private int money;
    private LocalTime time;
    // TODO Andere dingen ipv hiervan

    public ZooMemento(int money, LocalTime time){
        this.money = money;
        this.time = time;
    }

    public String getMemento(){
        return "Geld: " + this.money + "  Tijd: " + time;
    }
}
