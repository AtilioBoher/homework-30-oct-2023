package com.laba.aboher.models;

import com.laba.aboher.interfaces.IFly;

import java.util.Objects;

public final class Eagle extends Animal implements IFly {
    public Eagle(String specie, String status) {
        super(specie, status);
    }

    static {
        System.out.println("Creating an eagle: String from static block");
    }

    @Override
    public void makeNoise() {
        System.out.println("Eagle screams...");
    }

    @Override
    public void move() {
        System.out.println("Eagle moves...");
    }

    @Override
    public void fly() {
        System.out.println("Eagle flies...");
    }

    @Override
    public String toString() {
        return "Eagle{} " + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Eagle e = (Eagle) o;
        return getSPECIE().equals(e.getSPECIE()) &&
                getStatus().equals(e.getStatus()) &&
                health == e.health && // I can access this superclass field only because it's protected.
                getHunger() == e.getHunger() &&
                getTiredness() == e.getTiredness();
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                getSPECIE(),
                getStatus(),
                getHealth(),
                getHunger(),
                getTiredness());
    }
}