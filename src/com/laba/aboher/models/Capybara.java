package com.laba.aboher.models;

import com.laba.aboher.interfaces.IRun;

import java.util.Objects;

public class Capybara extends Animal implements IRun {

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
            System.out.println("invalid level of cuteness");
            return;
        }
        this.cuteness = cuteness;
    }

    @Override
    public void makeNoise() {
        System.out.println("Huff, huff.");
    }

    @Override
    public void move() {
        System.out.println("Capybara moves");
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
        System.out.println("Capybara runs...");
    }
}
