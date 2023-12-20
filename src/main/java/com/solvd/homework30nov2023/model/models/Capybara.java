package com.solvd.homework30nov2023.model.models;

import com.solvd.homework30nov2023.model.interfaces.IRun;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Objects;

public class Capybara extends Animal implements IRun {

    private static final Logger LOGGER = LogManager.getLogger(Capybara.class);

    protected int cuteness;    // percent level of the capybara's cuteness
    // we have a lot of those here in Argentina,
    // A friend of my have one as a pets.

    public Capybara(String specie, String status, int age) {
        super(specie, status, age);
        this.cuteness = 100;
    }

    public int getCuteness() {
        return cuteness;
    }

    public void setHappiness(int cuteness) {
        if (cuteness < 0 || cuteness > 100) {
            LOGGER.debug("invalid level of cuteness");
            return;
        }
        this.cuteness = cuteness;
    }

    @Override
    public void makeNoise() {
        LOGGER.info("Huff, huff.");
    }

    @Override
    public void move() {
        LOGGER.info("Capybara moves");
    }

    @Override
    public String toString() {
        return "Capybara{" +
                "cuteness=" + cuteness +
                "} " + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Capybara c = (Capybara) o;
        return cuteness == c.cuteness &&
                getSpecie().equals(c.getSpecie()) &&
                getStatus().equals(c.getStatus()) &&
                health == c.health && // I can access this superclass field only because it's protected.
                getHunger() == c.getHunger() &&
                getTiredness() == c.getTiredness();
    }

    @Override
    public int hashCode() {
        return Objects.hash(cuteness,
                getSpecie(),
                getStatus(),
                getHealth(),
                getHunger(),
                getTiredness());
    }

    @Override
    public void run() {
        LOGGER.info("Capybara runs...");
    }
}
