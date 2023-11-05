package com.laba.aboher.models;

import com.laba.aboher.interfaces.IFly;

import java.util.Objects;

public final class Nightingale extends Animal implements IFly {


    public Nightingale(String specie, String status) {
        super(specie, status);
    }

    @Override
    public void makeNoise() {
        System.out.println("Nightingale sings...");
    }

    @Override
    public void move() {
        System.out.println("Nightingale moves...");
    }

    @Override
    public void fly() {
        System.out.println("Nightingale flies...");
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
        return getSPECIE().equals(n.getSPECIE()) &&
                getStatus().equals(n.getStatus()) &&
                health == n.health && // I can access this superclass field only because it's protected.
                getHunger() == n.getHunger() &&
                getTiredness() == n.getTiredness();
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
