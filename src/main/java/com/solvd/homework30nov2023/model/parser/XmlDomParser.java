package com.solvd.homework30nov2023.model.parser;

import com.solvd.homework30nov2023.model.Animal;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.LinkedList;
import java.util.List;

public class XmlDomParser {
    private static final Logger LOGGER = LogManager.getLogger(XmlDomParser.class);

    public static List<Animal> readAnimals(String filePath) {
        List<Animal> animals = new LinkedList<>();
        NodeList nodeList = getNodeList(filePath, "animal");
        for (int i = 0; i < nodeList.getLength(); i++) {
            Animal animal = new Animal();
            Node node = nodeList.item(i);
            readAnimalAttributes(node, animal);
            readAnimalElements(node, animal);
            animals.add(animal);
        }
        return animals;
    }

    private static void readAnimalElements(Node node, Animal animal) {
        NodeList childs = node.getChildNodes();
        Node current;
        for (int j = 0; j < childs.getLength(); j++) {
            current = childs.item(j);
            if (current.getNodeType() == Node.ELEMENT_NODE) {
                switch (current.getNodeName()) {
                    case "name":
                        animal.setName(current.getTextContent());
                        break;
                    case "age":
                        animal.setAge(Integer.parseInt(current.getTextContent()));
                        break;
                    case "specie":
                        animal.setSpecie(current.getTextContent());
                        break;
                    case "attractionId":
                        animal.setAttractionId(Long.parseLong(current.getTextContent()));
                }
            }
        }
    }

    private static void readAnimalAttributes(Node node, Animal animal) {
        NamedNodeMap attrList = node.getAttributes();
        for (int j = 0; j < attrList.getLength(); j++) {
            if ("id".equals(attrList.item(j).getNodeName())) {
                animal.setId(Long.parseLong(attrList.item(j).getNodeValue()));
            }
        }
    }

    private static NodeList getNodeList(String filePath, String tagName) {
        DocumentBuilder builder = null;
        Document doc = null;
        NodeList nodeList = null;
        try {
            builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            doc = builder.parse(new File(filePath));
            doc.getDocumentElement().normalize();
            nodeList = doc.getElementsByTagName(tagName);
        } catch (Exception e) {
            LOGGER.error(e);
        }
        return nodeList;
    }
}