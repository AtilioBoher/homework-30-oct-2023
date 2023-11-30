package com.solvd.homework30nov2023.enums;

public enum Pet {
    CAT(Specie.CAT) ,
    DOG(Specie.DOG);

    final Specie specie;

    Pet(Specie specie) {
        this.specie = specie;
    }

    public Specie getSpecie() {
        return specie;
    }
}
