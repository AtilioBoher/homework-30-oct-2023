package com.laba.aboher.models;

import com.laba.aboher.interfaces.IRun;
import com.laba.aboher.interfaces.Pettable;

import java.util.Objects;

public class Cat extends Animal implements IRun, Pettable {

    private static int numberOfCats = 0; // count the number of cats

    protected int happiness; // percent level of the cat happiness

    public Cat(String specie, String status) {
        super(specie, status);
        this.happiness = 100;
        numberOfCats++;
    }

    public static int getNumberOfCats() { // Doesn't have a setter because it's
        return numberOfCats;              // not meant to be changed by the user,
    }                                     // it increments by itself when the
                                          // constructor it's called.

    public int getHappiness() {
        return happiness;
    }

    public void setHappiness(int happiness) {
        if (happiness < 0 || happiness > 100) {
            System.out.println("invalid level of happiness");
            return;
        }
        this.happiness = happiness;
    }

    @Override
    public void makeNoise() {
        System.out.println("Miaw, miaw.");
    }

    @Override
    public void move() {
        System.out.println("Cat moves");
    }

    @Override
    public String toString() {
        return "Cat{" +
                "happiness=" + happiness +
                "} " + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cat c = (Cat) o;
        return happiness == c.happiness &&
                getSpecie().equals(c.getSpecie()) &&
                getStatus().equals(c.getStatus()) &&
                health == c.health && // I can access this superclass field only because it's protected.
                getHunger() == c.getHunger() &&
                getTiredness() == c.getTiredness();
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
        System.out.println("Cat runs...");
    }

    @Override
    public void letHimSelfBePet() {
        System.out.println("I'm being petted, I'm happy and follow the one who petted me...!!!");
        setHappiness(100);
    }
}
