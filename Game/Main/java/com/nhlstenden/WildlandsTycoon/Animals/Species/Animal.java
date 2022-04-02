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

    /***
     * Bereken de appeal aan de hand van de state en de bijbehorende penalties
     * Als animal slaapt, is de appeal 20% minder
     * @return De appeal
     */
    public double getAppeal() {
        Boolean isSleeping = this.state.isSleeping();
        double multiplier = (100 - getStatePenalty(this.state.getHunger()) - getStatePenalty(this.state.getTemperatureContentment()) - getStatePenalty(this.state.getStress())) / 100;
        if (multiplier > 0.0){
            if(isSleeping){
                if (multiplier > 0.2){
                    return  (baseAppeal * multiplier) - (baseAppeal * 0.2);
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

    /**
     * Bereken een straf aan de hand van een state waarde
     * 0-25     → Geen straf
     * 25-50    → De helft van de waarde als straf
     * 50-75    → De gehele waarde als straf
     * 75+      → drie keer de waarde als straf, zodat de appeal altijd 0 wordt
     * @param stateValue de waarde van de state
     * @return de straf
     */
    private double getStatePenalty(double stateValue){
        double result;
        if (stateValue > 20) {
            if (stateValue > 60){
                if (stateValue > 80){
                        result = stateValue * 3;
                } else {
                    result =  stateValue;
                }
            } else {
                result =  stateValue / 2;
            }
        } else {
            return 0;
        }
        return result / 3;
    }

    public void updateState(double temperature, int amountOfGuests) {
        this.updateTemperatureContentment(temperature);
        this.updateStress(amountOfGuests);
        this.updateHunger();
        this.updateFatigue();
    }

    public void update(double temperature, int amountOfGuests) {
        updateState(temperature, amountOfGuests);
        tryWakeUp();
    }


    private void updateStress(int amountOfGuests){
        //ToDo amount of guests checken
        if (amountOfGuests > 1000 && !state.isSleeping()) {
            this.state.setStress(this.state.getStress() + ((amountOfGuests - 1000d) / 1000d));
        }
        if(this.state.getHunger() > 50 && !state.isSleeping())
        {
            this.state.setStress(this.state.getStress() + this.state.getHunger() / 100);
        }
        else {
            this.state.setStress(0);
        }
    }

    /***
     * Update de tevredenheid van animal met de temperatuur
     * Dit wordt verhoogd met 5 * het temperatuurverschil als het niet voldoet aan de minimumtemperatuur of maximumtemperatuur
     * Anders wordt het met 10 verlaagt
     * @param temperature De huidige temperatuur
     */
    private void updateTemperatureContentment(Double temperature){
        //update temp confinement
        if (temperature < minTemperature){
            this.state.setTemperatureContentment(this.state.getTemperatureContentment() + ((minTemperature - temperature) * 5));
        } else if (temperature > maxTemperature){
            this.state.setTemperatureContentment(this.state.getTemperatureContentment() + ((temperature - maxTemperature) * 5));
        } else {
            this.state.setTemperatureContentment(this.state.getTemperatureContentment() - 10);
        }
    }

    /***
     * Verhoog de honger van de animal
     * Dit wordt met zon getal verhoogt dat er ongeveer 2 keer per dag gegeten moet worden
     */
    private void updateHunger(){
        if (this.state.getHunger() < 100 - (100.0 / (12 * 6))) {
            this.state.setHunger(this.state.getHunger() + (100.0 / (12 * 6)));
        } else {
            this.state.setHunger(100);
        }
    }

    /***
     * Update de fatigue van animal
     * Dit wordt met zon getal gedaan dat de dagelijkse uren slaap zo dicht mogelijk worden benadert
     */
    private void updateFatigue(){
        if (this.state.isSleeping()) {
            this.state.setFatigue(this.state.getFatigue() - (100 / (dailyHoursOfSleep * 6)));
        } else {
            this.state.setFatigue(this.state.getFatigue() + (100 / ((24 - dailyHoursOfSleep) * 6)));
        }
    }

    private void tryWakeUp(){
        if (this.state.isSleeping() && this.state.getFatigue() <= 0){
            this.wakeUp();
        } else if (this.state.getFatigue() >= 100){
            this.sleep();
        }
    }

    public void wakeUp() {
        this.state.setSleeping(false);
    }

    public void sleep() {
        this.state.setSleeping(true);
    }

    //changes in factory per animal
    public abstract int feed();
}
