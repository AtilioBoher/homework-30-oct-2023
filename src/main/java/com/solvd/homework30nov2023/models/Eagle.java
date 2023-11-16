package com.solvd.homework30nov2023.models;

import com.solvd.homework30nov2023.interfaces.IFly;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Objects;

public final class Eagle extends Animal implements IFly {

    private static final Logger LOGGER = LogManager.getLogger(Eagle.class);
    
    public Eagle(String specie, String status, int age) {
        super(specie, status, age);
    }

    static {
        LOGGER.info("Creating an eagle: String from static block");
    }

    @Override
    public void makeNoise() {
        LOGGER.info("Eagle screams...");
    }

    @Override
    public void move() {
        LOGGER.info("Eagle moves...");
    }

    @Override
    public void fly() {
        LOGGER.info("Eagle flies...");
    }

    @Override
    public String toString() {
        return "Eagle{} " + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Eagle e = (Eagle) o;
        return getSpecie().equals(e.getSpecie()) &&
                getStatus().equals(e.getStatus()) &&
                health == e.health && // I can access this superclass field only because it's protected.
                getHunger() == e.getHunger() &&
                getTiredness() == e.getTiredness();
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                getSpecie(),
                getStatus(),
                getHealth(),
                getHunger(),
                getTiredness());
    }
}
