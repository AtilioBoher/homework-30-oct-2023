package com.laba.aboher.models;

public class Hunter extends Person{
    private Riffle riffle;

    public Hunter(String name,Riffle riffle) {
        super("Hunter", name);
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
}
