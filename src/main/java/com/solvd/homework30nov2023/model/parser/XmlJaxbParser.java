package com.solvd.homework30nov2023.model.parser;

import com.solvd.homework30nov2023.model.Animal;
import com.solvd.homework30nov2023.model.Animals;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.util.List;

public class XmlJaxbParser {
    private static final Logger LOGGER = LogManager.getLogger(XmlJaxbParser.class);

    /**
     * Parse an XML file in search for a list of Animal instances using the JAXB library
     *
     * @param filePath Path to the XML file
     * @return List of the animals found in the XML file
     */
    public static List<Animal> readAnimals(String filePath) {
        Animals animals = new Animals(); // This is like a wrapper object, because JAXB parse the root elements, which is "animals"
        try {
            JAXBContext context = JAXBContext.newInstance(Animals.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            animals = (Animals) unmarshaller.unmarshal(new File(filePath));
        } catch (JAXBException e) {
            LOGGER.error(e);
        }
        return animals.getAnimals();
    }
}
