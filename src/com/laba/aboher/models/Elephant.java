package com.laba.aboher.models;

import com.laba.aboher.Main;
import com.laba.aboher.interfaces.IRun;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Objects;

public class Elephant extends Animal implements IRun {

    private static final Logger LOGGER = LogManager.getLogger(Elephant.class);

    protected int aggressiveness; // percent level of the elephant's aggressiveness

    public Elephant(String specie, String status, int age) {
        super(specie, status, age);
        this.aggressiveness = 0;
    }

    public int getAggressiveness() {
        return aggressiveness;
    }

    public void setAggressiveness(int aggressiveness) {
        if (aggressiveness < 0 || aggressiveness > 100) {
            LOGGER.debug("invalid level of aggressiveness");
            return;
        }
        this.aggressiveness = aggressiveness;
    }

    @Override
    public void makeNoise() {
        LOGGER.info("Fiiiuuuuuuuuuuuu!!!.");
    }

    @Override
    public void move() {
        LOGGER.info("Elephant moves");
    }

    @Override
    public String toString() {
        return "Elephant{" +
                "aggressiveness=" + aggressiveness +
                "} " + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Elephant e = (Elephant) o;
        return aggressiveness == e.aggressiveness &&
                getSpecie().equals(e.getSpecie()) &&
                getStatus().equals(e.getStatus()) &&
                health == e.health && // I can access this superclass field only because it's protected.
                getHunger() == e.getHunger() &&
                getTiredness() == e.getTiredness();
    }

    @Override
    public int hashCode() {
        return Objects.hash(aggressiveness,
                getSpecie(),
                getStatus(),
                getHealth(),
                getHunger(),
                getTiredness());
    }

    @Override
    public void run() {
        LOGGER.info("Elephant runs...");
    }
}
