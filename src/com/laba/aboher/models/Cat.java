package com.laba.aboher.models;

public class Cat extends Animal{

    public int happiness; // percent level of the cat happiness

    public Cat(String specie, String status) {
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
        System.out.println("Miaw, miaw.");
    }

    @Override
    public void move() {
        System.out.println("Cat moves");
    }

}
