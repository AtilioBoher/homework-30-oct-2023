package com.laba.aboher.models;

import com.laba.aboher.exceptions.InvalidAgeException;
import com.laba.aboher.exceptions.InvalidHealthException;
import com.laba.aboher.exceptions.InvalidHungerException;
import com.laba.aboher.exceptions.InvalidTirednessException;

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

    public void setAge(int age) throws InvalidAgeException {
        if (age < 0) {
            throw new InvalidAgeException(String.format("Invalid input age: " +
                    "%d. Age can't be lower than 0.", age));
        }
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

    public void setHealth(int health) throws InvalidHealthException {
        if (health < 0) {
            throw new InvalidHealthException(String.format("Invalid health: " +
                    "%d. Health can not be lower than 0.", health));
        }
        if(health > 100) {
            throw new InvalidHealthException(String.format("Invalid health: " +
                    "%d. Health can not be greater than 100.", health));
        }
        this.health = health;
    }

    public int getHunger() {
        return hunger;
    }

    public void setHunger(int hunger) throws InvalidHungerException {
        if (hunger < 0) {
            throw new InvalidHungerException(String.format("Invalid " +
                            "hunger level: %d. Hunger can not be lower than 0.",
                    hunger));
        }
        if(hunger > 100) {
            throw new InvalidHungerException(String.format("Invalid hunger " +
                            "level: %d. Hunger can not be greater than 100.",
                    hunger));
        }
        this.hunger = hunger;
    }

    public int getTiredness() {
        return tiredness;
    }

    public void setTiredness(int tiredness) throws InvalidTirednessException {
        if (tiredness < 0) {
            throw new InvalidTirednessException(String.format("Invalid " +
                    "tiredness level: %d. Tiredness can not be lower than 0.",
                    tiredness));
        }
        if(tiredness > 100) {
            throw new InvalidTirednessException(String.format("Invalid" +
                    "tiredness level: %d. Tiredness can not be greater than 100.",
                    tiredness));
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
