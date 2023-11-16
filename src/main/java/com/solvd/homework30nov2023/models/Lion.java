package com.solvd.homework30nov2023.models;

import com.solvd.homework30nov2023.interfaces.IKillPrey;
import com.solvd.homework30nov2023.interfaces.IRun;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Objects;

public class Lion extends Animal implements IRun, IKillPrey {

    private static final Logger LOGGER = LogManager.getLogger(Lion.class);
    protected int aggressiveness; // percent level of the lion's aggressiveness

    public Lion(String specie, String status, int age) {
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
        LOGGER.info("Graaaauuu!!!.");
    }

    @Override
    public void move() {
        LOGGER.info("Lion moves");
    }

    @Override
    public String toString() {
        return "Lion{" +
                "aggressiveness=" + aggressiveness +
                "} " + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lion l = (Lion) o;
        return aggressiveness == l.aggressiveness &&
                getSpecie().equals(l.getSpecie()) &&
                getStatus().equals(l.getStatus()) &&
                health == l.health && // I can access this superclass field only because it's protected.
                getHunger() == l.getHunger() &&
                getTiredness() == l.getTiredness();
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
        LOGGER.info("Lion runs...");
    }

    @Override
    public void killPray() {
        LOGGER.info("I'm a Lion, and I've killed a prey to eat");
    }

}
