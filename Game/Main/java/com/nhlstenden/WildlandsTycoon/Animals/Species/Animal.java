package com.nhlstenden.WildlandsTycoon.Animals.Species;

import com.nhlstenden.WildlandsTycoon.Animals.Enums.AnimalSpecies;
import com.nhlstenden.WildlandsTycoon.Animals.Enums.Habitat;
import com.nhlstenden.WildlandsTycoon.Animals.State;

public abstract class Animal {
    //ToDo edit child methods
    protected Double baseAppeal;
    protected Double dailyHoursOfSleep;
    //Temperature in C°
    protected Double maxTemperature;
    protected Double minTemperature;

    protected Habitat habitat;
    protected State state;
    protected AnimalSpecies species;

    //changes in factory per animal
    public AnimalSpecies getSpecies() {
        return species;
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
        return minTemperature;
    }

    public void setMinTemperature(Double minTemperature) {
        this.minTemperature = minTemperature;
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

    public Double getBaseAppeal() {
        return baseAppeal;
    }

    public double getAppeal() {
        double hunger = this.state.getHunger();
        double tempContempment = this.state.getTemperatureContentment();
        double stress = this.state.getStress();
        Boolean isSleeping = this.state.isSleeping();
        //ToDo Appeal niet linear bepalen meer pas vanaf 50 % ofzo
        double multiplier = (100 - (hunger / 3) - (tempContempment / 3) - (stress / 3)) / 100;
        if (multiplier > 0.0){
            if(isSleeping){
                if (multiplier > 0.2){
                    return  baseAppeal * multiplier - baseAppeal * 0.2;
                } else {
                    return 0.0;
                }
            } else {
                return baseAppeal * multiplier;
            }
        } else {
            return 0.0;
        }
    }

    public void updateState(Double temperature, int amountOfGuests) {
        //ToDo check parameters voor hoeveelheden
        //update temp confinement
        if (temperature < minTemperature){
            this.state.setTemperatureContentment(this.state.getTemperatureContentment() - (minTemperature - temperature * 5));
        }
        else if (temperature > maxTemperature){
            this.state.setTemperatureContentment(this.state.getTemperatureContentment() - (temperature - maxTemperature * 5));
        }
        //update stress
        //ToDo amount of guests checken
        if (amountOfGuests > 1000) {
            this.state.setStress(this.state.getStress() * ((amountOfGuests - 1000) / 1000));
        }
        //update hunger
        this.state.setHunger(this.state.getHunger() + 5);
        //update fatigue
        if (this.state.isSleeping()) {
            this.state.setFatigue(this.state.getFatigue() - 10);
        } else {
            this.state.setFatigue(this.state.getFatigue() + 10);
        }
    }

    public void update(Double temperature, int AmountOfGuests) {
        updateState(temperature, AmountOfGuests);
        if (this.state.isSleeping() && this.state.getFatigue() <= 0){
            this.wakeUp();
        } else if (this.state.getFatigue() >= 100){
            this.sleep();
        }
        //ToDo niet automatisch eten geven
//        if (this.state.getHunger() > 50 && !state.isSleeping()){
//            this.feed();
//        }
    }

    //changes in factory per animal
    public abstract void feed();

    public abstract void wakeUp();

    public abstract void sleep();

}
