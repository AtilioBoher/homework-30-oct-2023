package com.solvd.homework30nov2023.designPatterns.decorator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DogWasher implements DogService {
    private static final Logger LOGGER = LogManager.getLogger(DogWasher.class);

    @Override
    public void serviceDog() {
        LOGGER.info("Wash dog...");
    }
}
