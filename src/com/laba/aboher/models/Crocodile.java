package com.laba.aboher.models;

import com.laba.aboher.interfaces.IKillPrey;
import com.laba.aboher.interfaces.IRun;

import java.util.Objects;

public class Crocodile extends Animal implements IRun, IKillPrey {

    protected int aggressiveness; // percent level of the crocodile's aggressiveness

    public Crocodile(String specie, String status) {
        super(specie, status);
        this.aggressiveness = 0;
    }

    public int getAggressiveness() {
        return aggressiveness;
    }

    public void setAggressiveness(int aggressiveness) {
        if (aggressiveness < 0 || aggressiveness > 100) {
            System.out.println("invalid level of aggressiveness");
            return;
        }
        this.aggressiveness = aggressiveness;
    }

    @Override
    public void makeNoise() {
        System.out.println("Grrrrrrrr!!!.");
    }

    @Override
    public void move() {
        System.out.println("Crocodile moves");
    }

    public void swim() {
        System.out.println("Crocodile swims");
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
                getSPECIE().equals(c.getSPECIE()) &&
                getStatus().equals(c.getStatus()) &&
                health == c.health && // I can access this superclass field only because it's protected.
                getHunger() == c.getHunger() &&
                getTiredness() == c.getTiredness();
    }

    @Override
    public int hashCode() {
        return Objects.hash(aggressiveness,
                getSPECIE(),
                getStatus(),
                getHealth(),
                getHunger(),
                getTiredness());
    }

    @Override
    public void Run() {
        System.out.println("Crocodile runs...");
    }

    @Override
    public void killPray() {
        System.out.println("I'm a Crocodile, and I've killed a prey to eat");
    }
}