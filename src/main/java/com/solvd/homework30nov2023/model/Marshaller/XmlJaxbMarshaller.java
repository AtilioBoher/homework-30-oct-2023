package com.solvd.homework30nov2023.model.Marshaller;

import com.solvd.homework30nov2023.model.Animal;
import com.solvd.homework30nov2023.model.Animals;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.util.List;

public class XmlJaxbMarshaller {
    private static final Logger LOGGER = LogManager.getLogger(XmlJaxbMarshaller.class);

    public static void writeAnimals(List<Animal> animals, String filePath) {
        Animals aux = new Animals(animals);
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Animals.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            File file = new File(filePath);
            jaxbMarshaller.marshal(aux, file);
        } catch (JAXBException e) {
            LOGGER.error(e);
        }
    }
}
