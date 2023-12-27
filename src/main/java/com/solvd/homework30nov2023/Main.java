package com.solvd.homework30nov2023;

import com.solvd.homework30nov2023.dao.mybatis.AnimalDao;
import com.solvd.homework30nov2023.dao.mybatis.DepartmentDao;
import com.solvd.homework30nov2023.dao.mybatis.EmployeeDao;
import com.solvd.homework30nov2023.model.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.*;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

public class Main {

    private static final Logger LOGGER = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
//        myBatisHomeTask();
        xmlParsingHomeTask();
    }

    private static void employeeTest() {
        EmployeeDao employeeDao = new EmployeeDao();

        LOGGER.info("Update and display: ");
        Employee employee = new Employee(2L, "Atilio", "Boher", "Tester", 10);
        employeeDao.update(employee, employee.getId());

        Optional<Employee> optional = employeeDao.getById(2L);
        if (optional.isPresent()) {
            LOGGER.info("getById: " + optional.get() + "\n");
        } else {
            LOGGER.info("getById: Entry not found");
        }

        LOGGER.info("Insert and then display the entire table: ");
        employee.setId(employeeDao.insert(employee));
        LOGGER.info("Generated Id of the new entry: " + employee.getId());
//
        List<Employee> employees = employeeDao.getAll();
        for (Employee e : employees) {
            LOGGER.info(e);
        }
//
        LOGGER.info("\n");
//
        LOGGER.info("Delete added entry and then display the entire table: ");
        employeeDao.removeById(employee.getId());
        employees = employeeDao.getAll();
        for (Employee e : employees) {
            LOGGER.info(e);
        }
    }

    private static void animalTest() {
        AnimalDao animalDao = new AnimalDao();

        LOGGER.info("Update and display: ");
        Animal animal = new Animal(1L, "myAnimal", 10, "miAnimal", 1L);
        animalDao.update(animal, animal.getId());

        Optional<Animal> optional = animalDao.getById(1L);
        if (optional.isPresent()) {
            LOGGER.info("getById: " + optional.get() + "\n");
        } else {
            LOGGER.info("getById: Entry not found");
        }

        LOGGER.info("Insert and then display the entire table: ");
        animal.setId(animalDao.insert(animal));
        LOGGER.info("Generated Id of the new entry: " + animal.getId());

        List<Animal> animals = animalDao.getAll();
        for (Animal a : animals) {
            LOGGER.info(a);
        }

        LOGGER.info("\n");

        LOGGER.info("Delete added entry and then display the entire table: ");
        animalDao.removeById(animal.getId());
        animals = animalDao.getAll();
        for (Animal a : animals) {
            LOGGER.info(a);
        }
    }

    private static void departmentTest() {
        DepartmentDao departmentDao = new DepartmentDao();

        LOGGER.info("Update and display: ");
        Department department = new Department(1L, "asd", "description: asd", null);
        departmentDao.update(department, department.getId());

        Optional<Department> optional = departmentDao.getById(1L);
        if (optional.isPresent()) {
            LOGGER.info("getById: " + optional.get() + "\n");
        } else {
            LOGGER.info("getById: Entry not found");
        }

        LOGGER.info("Insert and then display the entire table: ");
        department.setId(departmentDao.insert(department));
        LOGGER.info("Generated Id of the new entry: " + department.getId());

        List<Department> departments = departmentDao.getAll();
        for (Department d : departments) {
            LOGGER.info(d);
        }

        LOGGER.info("\n");

        LOGGER.info("Delete added entry and then display the entire table: ");
        departmentDao.removeById(department.getId());
        departments = departmentDao.getAll();
        for (Department d : departments) {
            LOGGER.info(d);
        }
    }

    private static void myBatisHomeTask() {
        employeeTest();
        animalTest();
        departmentTest();
    }

    private static void xmlParsingHomeTask() {
        dom();

        try {
            sax();
        } catch (Exception e) {
            LOGGER.error(e);
        }
    }

    private static void dom() {
        DocumentBuilder builder = null;
        Document doc = null;
        try {
            builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            doc = builder.parse(new File("src/main/resources/example_jdom.xml"));
            doc.getDocumentElement().normalize();
        } catch (Exception e) {
            LOGGER.error(e);
        }
        NodeList nodeList = doc.getElementsByTagName("person");
        LOGGER.info(String.format("N° of Nodes: %s", nodeList.getLength()));
        Node firstNode = nodeList.item(0);
        LOGGER.info(String.format("First Node info: NodeType=%d NodeName=%s\n",
                firstNode.getNodeType(),
                firstNode.getNodeName()));

        NamedNodeMap attrList = firstNode.getAttributes();
        LOGGER.info(String.format("First Node's attribute info: NodeName=%s NodeValue=%s\n",
                attrList.item(0).getNodeName(),
                attrList.item(0).getNodeValue()));

        NodeList childNode = firstNode.getChildNodes();
        int n = childNode.getLength();
        Node current;
        for (int i=0; i<n; i++) {
            current = childNode.item(i);
            if(current.getNodeType() == Node.ELEMENT_NODE) {
                System.out.println(
                        current.getNodeName() + ": " + current.getTextContent());
            }
        }

        nodeList = doc.getElementsByTagName("person");
        Element first = (Element) nodeList.item(0);
        LOGGER.info(String.format("Attribute before being modified: %s", first.getAttribute("id")));
        first.setAttribute("id", "5");
        LOGGER.info(String.format("Attribute after being modified: %s\n", first.getAttribute("id")));
    }

    private static void sax() throws ParserConfigurationException, SAXException, IOException {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser saxParser = factory.newSAXParser();
        Handler peopleHandler = new Handler();

        saxParser.parse("src/main/resources/example_jsax.xml", peopleHandler);

        People people = peopleHandler.getPeople();

        List<Person> personList = people.getPeople();

        personList.forEach(LOGGER::info);
    }

}
