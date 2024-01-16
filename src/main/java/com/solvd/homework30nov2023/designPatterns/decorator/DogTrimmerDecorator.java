package com.solvd.homework30nov2023.designPatterns.decorator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DogTrimmerDecorator implements DogService {
    private static final Logger LOGGER = LogManager.getLogger(DogTrimmerDecorator.class);

    private final DogService dogService;

    public DogTrimmerDecorator(DogService dogService) {
        this.dogService = dogService;
    }

    @Override
    public void serviceDog() {
        dogService.serviceDog();
        LOGGER.info("Trim dog's hair...");
    }
}
