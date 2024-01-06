package com.solvd.homework30nov2023.model.parser;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.solvd.homework30nov2023.model.Animal;
import com.solvd.homework30nov2023.model.Animals;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class JsonJacksonParser {
    private static final Logger LOGGER = LogManager.getLogger(JsonJacksonParser.class);

    /**
     * Parse a JSON file in search for a list of Animal instances using the Jackson library
     *
     * @param filePath Path to the JSON file
     * @return List of the animals found in the JSON file
     */
    public static List<Animal> readAnimals(String filePath) {
        ObjectMapper mapper = new ObjectMapper();
        Animals animals = new Animals();
        try {
            animals = mapper.readValue(new File(filePath), Animals.class);
        } catch (IOException e) {
            LOGGER.error(e);
        }
        return animals.getAnimals();
    }
}
