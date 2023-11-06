package com.laba.aboher.models;

import com.laba.aboher.interfaces.IKillPrey;
import com.laba.aboher.interfaces.IRun;

import java.util.Objects;

public class Lion extends Animal implements IRun, IKillPrey {
    protected int aggressiveness; // percent level of the lion's aggressiveness

    public Lion(String specie, String status) {
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
        System.out.println("Graaaauuu!!!.");
    }

    @Override
    public void move() {
        System.out.println("Lion moves");
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
        System.out.println("Lion runs...");
    }

    @Override
    public void killPray() {
        System.out.println("I'm a Lion, and I've killed a prey to eat");
    }

}
