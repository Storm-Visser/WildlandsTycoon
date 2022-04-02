package com.nhlstenden.WildlandsTycoon.Animals.Creators;

import com.nhlstenden.WildlandsTycoon.Animals.Enums.AnimalSpecies;
import com.nhlstenden.WildlandsTycoon.Animals.Species.*;

public abstract class AnimalCreator {

    public abstract Animal createAnimal();

    public static Animal createAnimalBySpecies(AnimalSpecies species){
        switch (AnimalSpecies.valueOf(species.name())) {
            case CHIMPANZEE:
                return new ChimpanzeeCreator().createAnimal();
            case CROCODILE:
                return new CrocodileCreator().createAnimal();
            case FLAMINGO:
                return new FlamingoCreator().createAnimal();
            case GORILLA:
                return new GorillaCreator().createAnimal();
            case HIPPO:
                return new HippoCreator().createAnimal();
            case LION:
                return new LionCreator().createAnimal();
            case PARROT:
                return new ParrotCreator().createAnimal();
            case PENGUIN:
                return new PenguinCreator().createAnimal();
            case RING_TAILED_LEMUR:
                return new RingTailedLemurCreator().createAnimal();
            case SNOW_LEOPARD:
                return new SnowLeopardCreator().createAnimal();
            case TIGER:
                return new TigerCreator().createAnimal();
            case TORTOISE:
                return new TortoiseCreator().createAnimal();
            case NULL_ANIMAL:
                return new NullAnimalCreator().createAnimal();
            default:
                System.out.println("Invalid animal species");
                return new NullAnimalCreator().createAnimal();
        }
    }
}
