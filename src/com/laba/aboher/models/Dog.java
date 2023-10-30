package com.laba.aboher.models;

public class Dog extends Animal{

    public int happiness; // percent level of the dog happiness

    public Dog(String specie, String status) {
        super(specie, status);
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
    public void speak() {
        System.out.println("Woof, woof.");
    }

    @Override
    public void move() {
        System.out.println("Dog moves");
    }
}
