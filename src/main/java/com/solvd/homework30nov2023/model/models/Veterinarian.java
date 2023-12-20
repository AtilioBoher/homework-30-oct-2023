package com.solvd.homework30nov2023.model.models;

import com.solvd.homework30nov2023.model.exceptions.InvalidHealthException;
import com.solvd.homework30nov2023.model.interfaces.IRun;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Veterinarian extends Person implements IRun {

    private static final Logger LOGGER = LogManager.getLogger(Veterinarian.class);
    private Syringe syringe;

    public Veterinarian(String name, int age, Syringe syringe) {
        super("Veterinarian", name, age);
        this.syringe = syringe;
    }

    public Syringe getSyringe() {
        return syringe;
    }

    public void setSyringe(Syringe syringe) {
        this.syringe = syringe;
    }

    public void healAnimal(Animal animal) {
        if (animal.getHealth() > 50) {
            LOGGER.info("Animal's health is greater than 50%, it doesn't" +
                    " need to be healed yet");
            return;
        }
        if (!this.syringe.isLoaded()) {
            LOGGER.info("Syringe is not loaded! animal can't be healed");
            return;
        }
        try {
            animal.setHealth(100);
        } catch (InvalidHealthException e) {
            LOGGER.debug("Exception setting health: " + e);
        }
        this.syringe.setLoaded(false);
        LOGGER.info("Animal has been healed!");
    }

    @Override
    public void run() {
        LOGGER.info("Veterinarian runs...");
    }
}
