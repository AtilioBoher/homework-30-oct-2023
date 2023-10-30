package com.laba.aboher.models;

public class Crocodile extends Animal{

    public int aggressiveness; // percent level of the crocodile's aggressiveness

    public Crocodile(String specie, String status) {
        super(specie, status);
        this.aggressiveness = 0;
    }

    public int getAggressiveness() {
        return aggressiveness;
    }

    public void setAggressiveness(int aggressiveness) {
        if (aggressiveness < 0 || aggressiveness > 100) {
            System.out.println("invalid level of aggressiveness");
            return;
        }
        this.aggressiveness = aggressiveness;
    }

    @Override
    public void speak() {
        System.out.println("Grrrrrrrr!!!.");
    }

    @Override
    public void move() {
        System.out.println("Crocodile moves");
    }

    public void swim() {
        System.out.println("Crocodile swims");
    }
}
