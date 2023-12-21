package com.solvd.homework30nov2023.model;

public class Employee {
    private int id;
    private String firstName;
    private String lastName;
    private String position;
    private int yearsOfExperience;

    public Employee(int id, String firstName, String lastName, String position, int yearsOfExperience) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.position = position;
        this.yearsOfExperience = yearsOfExperience;
    }

    public Employee() {
        this.id = 0;
        this.firstName = "";
        this.lastName = "";
        this.position = "";
        this.yearsOfExperience = 0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    public void setYearsOfExperience(int yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", position='" + position + '\'' +
                ", yearsOfExperience=" + yearsOfExperience +
                '}';
    }
}
