package com.solvd.homework30nov2023.model.Marshaller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.solvd.homework30nov2023.model.Animal;
import com.solvd.homework30nov2023.model.Animals;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class JsonJacksonMarshaller {
    private static final Logger LOGGER = LogManager.getLogger(JsonJacksonMarshaller.class);

    public static void writeAnimals(List<Animal> animals, String filePath) {
        Animals aux = new Animals(animals);
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        try {
            objectMapper.writeValue(new File(filePath), aux);
        } catch (IOException e) {
            LOGGER.error(e);
        }
    }
}
