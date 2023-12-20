package com.solvd.homework30nov2023.model.enums;

public enum Bird {
    EAGLE(Specie.EAGLE),
    NIGHTINGALE(Specie.NIGHTINGALE);

    final Specie specie;

    Bird(Specie specie) {
        this.specie = specie;
    }

    public Specie getSpecie() {
        return specie;
    }

}
