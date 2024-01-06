package com.solvd.homework30nov2023;

import com.solvd.homework30nov2023.dao.mybatis.AnimalDao;
import com.solvd.homework30nov2023.dao.mybatis.DepartmentDao;
import com.solvd.homework30nov2023.dao.mybatis.EmployeeDao;
import com.solvd.homework30nov2023.model.Animal;
import com.solvd.homework30nov2023.model.Department;
import com.solvd.homework30nov2023.model.Employee;
import com.solvd.homework30nov2023.model.parser.XmlDomParser;
import com.solvd.homework30nov2023.model.parser.XmlJaxbParser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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
        LOGGER.info("-------------------------DOM parser------------------------------");
        dom();
        LOGGER.info("------------------------JAXB parser------------------------------");
        jaxb();
    }

    private static void dom() {
        String filePath = "src/main/resources/animals.xml";
        List<Animal> animals = XmlDomParser.readAnimals(filePath);
        animals.forEach(LOGGER::info);
    }

    private static void jaxb() {
        String filePath = "src/main/resources/animals.xml";
        List<Animal> animals = XmlJaxbParser.readAnimals(filePath);
        animals.forEach(LOGGER::info);
    }


}
