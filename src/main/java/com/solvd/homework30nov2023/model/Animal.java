package com.solvd.homework30nov2023.model;

public class Animal {
    private Long id;
    private String name;
    private int age;
    private String specie;
    private Long attractionId;

    public Animal(Long id, String name, int age, String specie, Long atractionId) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.specie = specie;
        this.attractionId = atractionId; // this field is mandatory because an animal cannot be outside and attraction or cage
    }

    public Animal() {
        this.id = 0L;
        this.name = "";
        this.age = 0;
        this.specie = "";
        this.attractionId = 0L;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSpecie() {
        return specie;
    }

    public void setSpecie(String specie) {
        this.specie = specie;
    }

    public Long getAttractionId() {
        return attractionId;
    }

    public void setAttractionId(Long attractionId) {
        this.attractionId = attractionId;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", specie='" + specie + '\'' +
                ", attractionId=" + attractionId +
                '}';
    }
}
