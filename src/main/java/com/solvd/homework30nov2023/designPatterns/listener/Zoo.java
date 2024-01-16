package com.solvd.homework30nov2023.designPatterns.listener;

import com.solvd.homework30nov2023.model.Animal;

import java.util.ArrayList;
import java.util.List;

public class Zoo {
    private String name;
    private List<Animal> animals;

    public Zoo() {
        this.animals = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Animal> getAnimals() {
        return animals;
    }

    public void setAnimals(List<Animal> animals) {
        this.animals = animals;
    }

    public void addAnimal(Animal animal) {
        AnimalListenersHolder.onAddingAnimal(animal);
        animals.add(animal);
    }

    public void removeAnimal(Animal animal) {
        AnimalListenersHolder.onRemovingAnimal(animal);
        animals.remove(animal);
    }
}
