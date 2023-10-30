package com.laba.aboher.models;

public class Lion extends Animal{
    public int aggressiveness; // percent level of the lion's aggressiveness

    public Lion(String specie, String status) {
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
        System.out.println("Graaaauuu!!!.");
    }

    @Override
    public void move() {
        System.out.println("Lion moves");
    }
}
