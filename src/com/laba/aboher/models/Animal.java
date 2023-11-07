package com.laba.aboher.models;

public abstract class Animal {

    private int age;
    private final String SPECIE;  // specie the animal belongs, for example: dog, cat,
                            // lion, snake.
    private String status;  // it could be Domestic, Wild (meaning that is in
                            // the wild), Zoo (meaning that is in the zoo),
                            // Endangered (in danger of extinction)
    protected int health;     // percent level of health

    private int hunger;     // percent level of hunger

    private int tiredness;  // percent level of tiredness

    public Animal(String specie, String status, int age) {
        this.SPECIE = specie;
        this.status = status;
        this.age = age;
        this.health = 100;
        this.hunger = 0;
        this.tiredness = 0;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public final String getSpecie() { // this field does not have a setter because
        return this.SPECIE;     // is a final field, meaning that an animal
    }                           // can't change the specie it belongs, it's only
                                // defined in the constructor

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        if (health < 0 || health > 100) {
            System.out.println("invalid level of health");
            return;
        }
        this.health = health;
    }

    public int getHunger() {
        return hunger;
    }

    public void setHunger(int hunger) {
        if (hunger < 0 || hunger > 100) {
            System.out.println("invalid level of hunger");
            return;
        }
        this.hunger = hunger;
    }

    public int getTiredness() {
        return tiredness;
    }

    public void setTiredness(int tiredness) {
        if (tiredness < 0 || tiredness > 100) {
            System.out.println("invalid level of tiredness");
            return;
        }
        this.tiredness = tiredness;
    }

    public abstract void makeNoise();
    public abstract void move();

    @Override
    public String toString() {
        return "Animal{" +
                "specie='" + SPECIE + '\'' +
                ", status='" + status + '\'' +
                ", age=" + age +
                ", health=" + health +
                ", hunger=" + hunger +
                ", tiredness=" + tiredness +
                '}';
    }
}
