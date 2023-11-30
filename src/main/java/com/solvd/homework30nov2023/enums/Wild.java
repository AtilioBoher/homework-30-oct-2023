package com.solvd.homework30nov2023.enums;

public enum Wild {
    CAPYBARA(Specie.CAPYBARA),
    CROCODILE(Specie.CROCODILE),
    EAGLE(Specie.EAGLE),
    ELEPHANT(Specie.ELEPHANT),
    LION(Specie.LION);

    final Specie specie;

    Wild(Specie specie) {
        this.specie = specie;
    }

    public Specie getSpecie() {
        return specie;
    }
}
