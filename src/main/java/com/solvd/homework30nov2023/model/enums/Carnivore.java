package com.solvd.homework30nov2023.model.enums;

public enum Carnivore {
    CROCODILE(Specie.CROCODILE),
    LION(Specie.LION);

    final Specie specie;

    Carnivore(Specie specie) {
        this.specie = specie;
    }

    public Specie getSpecie() {
        return specie;
    }
}
