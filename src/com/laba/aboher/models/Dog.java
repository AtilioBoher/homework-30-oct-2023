package com.laba.aboher.models;

import com.laba.aboher.interfaces.IRun;
import com.laba.aboher.interfaces.Pettable;

import java.util.Objects;

public class Dog extends Animal implements IRun, Pettable {

    protected int happiness; // percent level of the dog happiness

    public Dog(String specie, String status, int age) {
        super(specie, status, age);
        this.happiness = 100;
    }

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
        System.out.println("Woof, woof.");
    }

    @Override
    public void move() {
        System.out.println("Dog moves");
    }

    @Override
    public String toString() {
        return "Dog{" +
                "happiness=" + happiness +
                "} " + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dog d = (Dog) o;
        return happiness == d.happiness &&
                getSpecie().equals(d.getSpecie()) &&
                getStatus().equals(d.getStatus()) &&
                health == d.health && // I can access this superclass field only because it's protected.
                getHunger() == d.getHunger() &&
                getTiredness() == d.getTiredness();
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
        System.out.println("Dog runs...");
    }

    @Override
    public void letHimSelfBePet() {
        System.out.println("I'm being petted, I'm happy and wag my tail...!!!");
        setHappiness(100);
    }
}
