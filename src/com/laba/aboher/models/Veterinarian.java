package com.laba.aboher.models;

public class Veterinarian extends Person{
    private Syringe syringe;

    public Veterinarian(String name,Syringe syringe) {
        super("Veterinarian", name);
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
        animal.setHealth(100);
        this.syringe.setLoaded(false);
        System.out.println("Animal has been healed!");
    }
}
