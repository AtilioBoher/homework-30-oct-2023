package com.solvd.homework30nov2023.designPatterns.listener;

import com.solvd.homework30nov2023.model.Animal;

import java.util.ArrayList;
import java.util.List;

public class AnimalListenersHolder {

    private static final List<AnimalListener> listeners = new ArrayList<>();

    public static void subscribe(AnimalListener animalListener) {
        listeners.add(animalListener);
    }

    public static void unSubscribe(AnimalListener animalListener) {
        listeners.remove(animalListener);
    }

    public static void onAddingAnimal(Animal animal) {
        listeners.forEach(listener -> {
            listener.onAddingAnimal(animal);
        });
    }

    public static void onRemovingAnimal(Animal animal) {
        listeners.forEach(listener -> {
            listener.onRemovingAnimal(animal);
        });
    }

}
