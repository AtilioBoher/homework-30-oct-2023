package com.solvd.homework30nov2023.models;

import com.solvd.homework30nov2023.interfaces.IFly;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Objects;

public final class Nightingale extends Animal implements IFly {

    private static final Logger LOGGER = LogManager.getLogger(Nightingale.class);

    public Nightingale(String specie, String status, int age) {
        super(specie, status, age);
    }

    @Override
    public void makeNoise() {
        LOGGER.info("Nightingale sings...");
    }

    @Override
    public void move() {
        LOGGER.info("Nightingale moves...");
    }

    @Override
    public void fly() {
        LOGGER.info("Nightingale flies...");
    }

    @Override
    public String toString() {
        return "Nightingale{} " + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Nightingale n = (Nightingale) o;
        return getSpecie().equals(n.getSpecie()) &&
                getStatus().equals(n.getStatus()) &&
                health == n.health && // I can access this superclass field only because it's protected.
                getHunger() == n.getHunger() &&
                getTiredness() == n.getTiredness();
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
