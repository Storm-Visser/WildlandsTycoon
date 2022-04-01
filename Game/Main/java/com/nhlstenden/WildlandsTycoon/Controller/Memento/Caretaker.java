package com.nhlstenden.WildlandsTycoon.Controller.Memento;

import com.nhlstenden.WildlandsTycoon.Controller.Controller;
import com.nhlstenden.WildlandsTycoon.Zoo.Zoo;

import java.util.ArrayList;

public class Caretaker {

    private ArrayList<ZooMemento> history;

    public Caretaker(){
        this.history = new ArrayList<ZooMemento>();
    }

    public void addMemento(ZooMemento memento){
        this.history.add(memento);
    }

    public ArrayList<ZooMemento> getHistory(){
        return this.history;
    }
}
