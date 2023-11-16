package com.solvd.homework30nov2023.models;

import com.solvd.homework30nov2023.interfaces.IRun;
import com.solvd.homework30nov2023.interfaces.Pettable;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Objects;

public class Dog extends Animal implements IRun, Pettable {

    private static final Logger LOGGER = LogManager.getLogger(Dog.class);

    protected int happiness; // percent level of the dog happiness

    public Dog(String specie, String status, int age) {
        super(specie, status, age);
        this.happiness = 100;
    }

    public int getHappiness() {
        return happiness;
    }

    public void setHappiness(int happiness) {
        if (happiness < 0 || happiness > 100) {
            LOGGER.debug("invalid level of happiness");
            return;
        }
        this.happiness = happiness;
    }

    @Override
    public void makeNoise() {
        LOGGER.info("Woof, woof.");
    }

    @Override
    public void move() {
        LOGGER.info("Dog moves");
    }

    @Override
    public String toString() {
        return "Dog{" +
                "happiness=" + happiness +
                "} " + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dog d = (Dog) o;
        return happiness == d.happiness &&
                getSpecie().equals(d.getSpecie()) &&
                getStatus().equals(d.getStatus()) &&
                health == d.health && // I can access this superclass field only because it's protected.
                getHunger() == d.getHunger() &&
                getTiredness() == d.getTiredness();
    }

    @Override
    public int hashCode() {
        return Objects.hash(happiness,
                getSpecie(),
                getStatus(),
                getHealth(),
                getHunger(),
                getTiredness());
    }

    @Override
    public void run() {
        LOGGER.info("Dog runs...");
    }

    @Override
    public void letHimSelfBePet() {
        LOGGER.info("I'm being petted, I'm happy and wag my tail...!!!");
        setHappiness(100);
    }
}
