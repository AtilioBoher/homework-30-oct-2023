package com.solvd.homework30nov2023.designPatterns.decorator;

public class DogStylist {

    public static void serviceDog(boolean trim, boolean perfume) {
        DogService dogService = new DogWasher();
        if (trim) {
            dogService = new DogTrimmerDecorator(dogService);
        }
        if (perfume) {
            dogService = new DogPerfumeDecorator(dogService);
        }
        dogService.serviceDog();
    }
}
