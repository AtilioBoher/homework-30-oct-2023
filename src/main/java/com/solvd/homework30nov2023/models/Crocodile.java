package com.solvd.homework30nov2023.models;

import com.solvd.homework30nov2023.interfaces.IKillPrey;
import com.solvd.homework30nov2023.interfaces.IRun;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Objects;

public class Crocodile extends Animal implements IRun, IKillPrey {

    private static final Logger LOGGER = LogManager.getLogger(Crocodile.class);

    protected int aggressiveness; // percent level of the crocodile's aggressiveness

    public Crocodile(String specie, String status, int age) {
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
        LOGGER.info("Grrrrrrrr!!!.");
    }

    @Override
    public void move() {
        LOGGER.info("Crocodile moves");
    }

    public void swim() {
        LOGGER.info("Crocodile swims");
    }

    @Override
    public String toString() {
        return "Crocodile{" +
                "aggressiveness=" + aggressiveness +
                "} " + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Crocodile c = (Crocodile) o;
        return aggressiveness == c.aggressiveness &&
                getSpecie().equals(c.getSpecie()) &&
                getStatus().equals(c.getStatus()) &&
                health == c.health && // I can access this superclass field only because it's protected.
                getHunger() == c.getHunger() &&
                getTiredness() == c.getTiredness();
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
        LOGGER.info("Crocodile runs...");
    }

    @Override
    public void killPray() {
        LOGGER.info("I'm a Crocodile, and I've killed a prey to eat");
    }
}
