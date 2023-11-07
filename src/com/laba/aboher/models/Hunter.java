package com.laba.aboher.models;

import com.laba.aboher.interfaces.IRun;

public class Hunter extends Person implements IRun {
    private Riffle riffle;

    public Hunter(String name, int age,Riffle riffle) {
        super("Hunter", name, age);
        this.riffle = riffle;
    }

    public Riffle getRiffle() {
        return riffle;
    }

    public void setRiffle(Riffle riffle) {
        this.riffle = riffle;
    }

    public void huntAnimal(Animal animal) {
        if (!animal.getStatus().equals("Wild")) {
            System.out.println("Animal is not wild, it can't be hunted");
            return;
        }
        System.out.println("Animal: " + animal.getSpecie() + " has been hunted");
        animal.setStatus("Hunted");
    }

    @Override
    public void run() {
        System.out.println("Hunter runs...");
    }
}
