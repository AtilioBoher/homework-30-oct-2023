package com.laba.aboher.models;

import com.laba.aboher.exceptions.NoWildAnimalException;
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

    public void huntAnimal(Animal animal) throws NoWildAnimalException {
        if (!animal.getStatus().equals("Wild")) {
            throw new NoWildAnimalException(
                    String.format("Animal status is: \"%s\". It must be \"Wild\" " +
                            "to be hunted.", animal.getStatus()));
        }
        System.out.println("Animal: " + animal.getSpecie() + " has been hunted");
        animal.setStatus("Hunted");
    }

    @Override
    public void run() {
        System.out.println("Hunter runs...");
    }
}
