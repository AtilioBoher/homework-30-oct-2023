package com.laba.aboher.models;

import com.laba.aboher.exceptions.InvalidAgeException;
import com.laba.aboher.interfaces.IPet;
import com.laba.aboher.interfaces.IRun;

public abstract class Person implements IPet {

    private int age;

    private String profession;
    private String name;

    public Person(String profession, String name, int age) {
        this.profession = profession;
        this.name = name;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) throws InvalidAgeException {
        if (age < 0) {
            throw new InvalidAgeException(String.format("Invalid input age: " +
                    "%d. Age can't be lower than zero", age));
        }
        this.age = age;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
