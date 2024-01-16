package com.solvd.homework30nov2023.designPatterns.decorator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DogPerfumeDecorator implements DogService {
    private static final Logger LOGGER = LogManager.getLogger(DogPerfumeDecorator.class);

    private final DogService dogService;

    public DogPerfumeDecorator(DogService dogService) {
        this.dogService = dogService;
    }

    @Override
    public void serviceDog() {
        dogService.serviceDog();
        LOGGER.info("Apply perfume to the dog...");
    }
}
