package com.solvd.homework30nov2023.designPatterns.listener;

import com.solvd.homework30nov2023.model.Animal;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class VeterinaryListener implements AnimalListener {
    private static final Logger LOGGER = LogManager.getLogger(VeterinaryListener.class);

    @Override
    public void onAddingAnimal(Animal animal) {
        LOGGER.info("Check vaccine certificate and applies missing vaccines");
        LOGGER.info("Assign animal tag id and secure it to the animal's collar");
    }

    @Override
    public void onRemovingAnimal(Animal animal) {
        LOGGER.info("Remove animal tag id from the animal's collar");
    }
}
