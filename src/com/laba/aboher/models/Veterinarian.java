package com.laba.aboher.models;

import com.laba.aboher.exceptions.InvalidHealthException;
import com.laba.aboher.interfaces.IRun;

public class Veterinarian extends Person implements IRun {
    private Syringe syringe;

    public Veterinarian(String name, int age,Syringe syringe) {
        super("Veterinarian", name, age);
        this.syringe = syringe;
    }

    public Syringe getSyringe() {
        return syringe;
    }

    public void setSyringe(Syringe syringe) {
        this.syringe = syringe;
    }

    public void healAnimal(Animal animal) {
        if (animal.getHealth() > 50) {
            System.out.println("Animal's health is greater than 50%, it doesn't" +
                    " need to be healed yet");
            return;
        }
        if (!this.syringe.isLoaded()) {
            System.out.println("Syringe is not loaded! animal can't be healed");
            return;
        }
        try {
            animal.setHealth(100);
        } catch (InvalidHealthException e) {
            System.out.println("Exception setting health: " + e);
        }
        this.syringe.setLoaded(false);
        System.out.println("Animal has been healed!");
    }

    @Override
    public void run() {
        System.out.println("Veterinarian runs...");
    }
}
