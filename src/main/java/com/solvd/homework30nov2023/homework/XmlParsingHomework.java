package com.solvd.homework30nov2023.homework;

import com.solvd.homework30nov2023.model.Animal;
import com.solvd.homework30nov2023.model.Marshaller.JsonJacksonMarshaller;
import com.solvd.homework30nov2023.model.Marshaller.XmlJaxbMarshaller;
import com.solvd.homework30nov2023.model.parser.JsonJacksonParser;
import com.solvd.homework30nov2023.model.parser.XmlDomParser;
import com.solvd.homework30nov2023.model.parser.XmlJaxbParser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class XmlParsingHomework {
    private static final Logger LOGGER = LogManager.getLogger(XmlParsingHomework.class);

    public static void xmlParsingHomeTask() {
        LOGGER.info("-------------------------DOM parser------------------------------");
        dom();
        LOGGER.info("------------------------JAXB parser------------------------------");
        jaxb();
        LOGGER.info("------------------------JSON parser------------------------------");
        json();
    }

    private static void dom() {
        String filePath = "src/main/resources/animalsReadFile.xml";
        List<Animal> animals = XmlDomParser.readAnimals(filePath);
        animals.forEach(LOGGER::info);
    }

    private static void jaxb() {
        String filePath = "src/main/resources/animalsReadFile.xml";
        List<Animal> animals = XmlJaxbParser.readAnimals(filePath);
        animals.forEach(LOGGER::info);

        filePath = "src/main/resources/animalsWriteFile.xml";
        XmlJaxbMarshaller.writeAnimals(animals, filePath);
    }

    private static void json() {
        String filePath = "src/main/resources/animalsReadFile.json";
        List<Animal> animals = JsonJacksonParser.readAnimals(filePath);
        animals.forEach(LOGGER::info);

        filePath = "src/main/resources/animalsWriteFile.json";
        JsonJacksonMarshaller.writeAnimals(animals, filePath);
    }
}
