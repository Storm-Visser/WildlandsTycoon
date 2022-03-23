package com.nhlstenden.WildlandsTycoon.Animals;

public class Animal {

    private Double baseAppeal;
    private Double dailyHoursOfSleep;
    //Temperature in C°
    private Double maxTemperature;
    private Double minTemperature;

    private Habitat habitat;
    private State state;

    public Animal(Double dailyHoursOfSleep, Double maxTemperature, Double minTemperature, Habitat habitat, State state) {
        this.baseAppeal = 50.0;
        this.dailyHoursOfSleep = dailyHoursOfSleep;
        this.maxTemperature = maxTemperature;
        this.minTemperature = minTemperature;
        this.habitat = habitat;
        this.state = state;
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

    public double getAppeal() {
        double hunger = this.state.getHunger();
        double tempContempment = this.state.getTemperatureContentment();
        double stress = this.state.getStress();
        Boolean isSleeping = this.state.isSleeping();
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
        //update temp confinement
        if (temperature < minTemperature){
            this.state.setTemperatureContentment(this.state.getTemperatureContentment() - (minTemperature - temperature * 5));
        }
        if (temperature > maxTemperature){
            this.state.setTemperatureContentment(this.state.getTemperatureContentment() - (temperature - maxTemperature * 5));
        }
        //update stress
        if (amountOfGuests > 1000) {
            this.state.setStress(this.state.getStress() * ((amountOfGuests - 1000) / 1000));
        }
        //update hunger
        this.state.setHunger(this.state.getHunger() + 5);
        //update fatigue
        if (this.state.isSleeping()) {
            this.state.setFatigue(this.state.getFatigue() + 20);
        } else {
            this.state.setFatigue(this.state.getFatigue() - 20);
        }
    }

    public void update(Double temperature, int AmountOfGuests) {
        updateState(temperature, AmountOfGuests);
        if (!this.state.isSleeping() && this.state.getFatigue() < 20){
            this.sleep();
        } else if (this.state.getFatigue() >= 100){
            this.wakeUp();
        }
        if (this.state.getHunger() > 50 && !state.isSleeping()){
            this.feed();
        }
    }

    //changes in factory per animal
    public void feed(){
        this.state.setHunger(0);
        System.out.println("Fed Animal X");
    }

    private void wakeUp(){
        this.state.setSleeping(false);
        System.out.println("Animal X woke up");
    }

    private void sleep(){
        this.state.setSleeping(true);
        System.out.println("Animal X fell asleep");
    }
}
