package com.laba.aboher.models;

public class Capybara extends Animal{

    public int cuteness;    // percent level of the capybara's cuteness
                            // we have a lot of those here in Argentina,
                            // A friend of my have one as a pets.

    public Capybara(String specie, String status) {
        super(specie, status);
        this.cuteness = 100;
    }

    public int getCuteness() {
        return cuteness;
    }

    public void setHappiness(int cuteness) {
        if (cuteness < 0 || cuteness > 100) {
            System.out.println("invalid level of cuteness");
            return;
        }
        this.cuteness = cuteness;
    }

    @Override
    public void speak() {
        System.out.println("Huff, huff.");
    }

    @Override
    public void move() {
        System.out.println("Capybara moves");
    }
}
