package com.solvd.homework30nov2023;

import com.solvd.homework30nov2023.dao.jdbc.AnimalDao;
import com.solvd.homework30nov2023.dao.jdbc.EmployeeDao;
import com.solvd.homework30nov2023.model.Animal;
import com.solvd.homework30nov2023.model.Employee;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class Main {

    private static final Logger LOGGER = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
//        employeeTest();
        animalTest();

    }

    private static void employeeTest() {
        EmployeeDao employeeDao = new EmployeeDao();

        LOGGER.info("Update display: ");
        Employee employee = new Employee(2, "Atilio", "Boher", "Tester", 1);
        employeeDao.update(employee);

        employee = employeeDao.getById(2);
        LOGGER.info("getById: " + employee + "\n");

        LOGGER.info("Insert and then display the entire table: ");
        employee.setId(employeeDao.insert(employee));
        LOGGER.info("Generated Id of the new entry: " + employee.getId());

        List<Employee> employees = employeeDao.getAll();
        for (Employee e : employees) {
            LOGGER.info(e);
        }

        LOGGER.info("\n");

        LOGGER.info("Delete added entry and then display the entire table: ");
        employeeDao.removeById(employee.getId());
        employees = employeeDao.getAll();
        for (Employee e : employees) {
            LOGGER.info(e);
        }
    }

    private static void animalTest() {
        AnimalDao animalDao = new AnimalDao();
//
        LOGGER.info("Update display: ");
        Animal animal = new Animal(1, "asd", 5, "asd", 1);
        animalDao.update(animal);
//
        animal = animalDao.getById(1);
        LOGGER.info("getById: " + animal + "\n");
//
        LOGGER.info("Insert and then display the entire table: ");
        animal.setId(animalDao.insert(animal));
        LOGGER.info("Generated Id of the new entry: " + animal.getId());
//
        List<Animal> animals = animalDao.getAll();
        for (Animal a : animals) {
            LOGGER.info(a);
        }
//
        LOGGER.info("\n");
//
        LOGGER.info("Delete added entry and then display the entire table: ");
        animalDao.removeById(animal.getId());
        animals = animalDao.getAll();
        for (Animal a : animals) {
            LOGGER.info(a);
        }
    }
}
