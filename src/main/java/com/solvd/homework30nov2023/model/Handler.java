package com.solvd.homework30nov2023.model;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class Handler extends DefaultHandler {
    private static final String PEOPLE = "people";
    private static final String PERSON = "person";
    private static final String NAME = "name";
    private static final String AGE = "age";

    private People people;
    private StringBuilder elementValue;

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (elementValue == null) {
            elementValue = new StringBuilder();
        } else {
            elementValue.append(ch, start, length);
        }
    }

    @Override
    public void startDocument() throws SAXException {
        people = new People();
    }

    @Override
    public void startElement(String uri, String lName, String qName, Attributes attr) throws SAXException {
        switch (qName) {
            case PEOPLE:
                people.setPeople(new ArrayList<>());
                break;
            case PERSON:
                people.getPeople().add(new Person());
                break;
            case NAME:
                elementValue = new StringBuilder();
                break;
            case AGE:
                elementValue = new StringBuilder();
                break;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        switch (qName) {
            case NAME:
                latestPerson().setName(elementValue.toString());
                break;
            case AGE:
                latestPerson().setAge(Integer.parseInt(elementValue.toString()));
                break;
        }
    }

    private Person latestPerson() {
        List<Person> articleList = people.getPeople();
        int latestArticleIndex = articleList.size() - 1;
        return articleList.get(latestArticleIndex);
    }

    public People getPeople() {
        return people;
    }
}
