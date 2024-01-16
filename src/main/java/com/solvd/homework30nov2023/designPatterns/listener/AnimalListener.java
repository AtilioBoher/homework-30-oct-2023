package com.solvd.homework30nov2023.designPatterns.listener;

import com.solvd.homework30nov2023.model.Animal;

public interface AnimalListener {

    void onAddingAnimal(Animal animal); // When an animal enters the zoo

    void onRemovingAnimal(Animal animal); // When an animal leaves the zoo
}
