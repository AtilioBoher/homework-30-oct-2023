package com.solvd.homework30nov2023.designPatterns.listener;

import com.solvd.homework30nov2023.model.Animal;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AdministrativeListener implements AnimalListener {
    private static final Logger LOGGER = LogManager.getLogger(AdministrativeListener.class);

    @Override
    public void onAddingAnimal(Animal animal) {
        LOGGER.info("Load animal's information to the database");
    }

    @Override
    public void onRemovingAnimal(Animal animal) {
        LOGGER.info("Delete animal from the database and remove collar tag id");
    }
}
