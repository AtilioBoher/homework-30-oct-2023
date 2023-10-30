package com.laba.aboher.models;

public abstract class Person {
    private String profession;
    private String name;

    public Person(String profession, String name) {
        this.profession = profession;
        this.name = name;
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
