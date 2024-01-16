package com.solvd.homework30nov2023.homework;

import com.solvd.homework30nov2023.dao.IAnimalDao;
import com.solvd.homework30nov2023.dao.IDepartmentDao;
import com.solvd.homework30nov2023.dao.IEmployeeDao;
import com.solvd.homework30nov2023.designPatterns.builder.Mascot;
import com.solvd.homework30nov2023.designPatterns.factory.RelationalRepositoriesFactory;
import com.solvd.homework30nov2023.designPatterns.factory.RepositoriesFactory;
import com.solvd.homework30nov2023.model.Animal;
import com.solvd.homework30nov2023.model.Department;
import com.solvd.homework30nov2023.model.Employee;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Optional;

public class DesignPatternsHomework {
    private static final Logger LOGGER = LogManager.getLogger(DesignPatternsHomework.class);

    public static void designPatternsHomework() {
//        factory();
//        abstractFactory();
        builder();
        LOGGER.info("-------------------------Listener Pattern--------------------------");
        LOGGER.info("-------------------------Facade Pattern----------------------------");
        LOGGER.info("-------------------------Decorator Pattern-------------------------");
        LOGGER.info("-------------------------Proxy Pattern-----------------------------");
        LOGGER.info("-------------------------Strategy Pattern--------------------------");
        // TODO: Check what MVC patterns I have to add, if I have to add it
    }

    private static void factory() {
        LOGGER.info("Employee Dao:");
        IEmployeeDao employeeDao = RelationalRepositoriesFactory.createEmployeeDao();
        Optional<Employee> employee = employeeDao.getById(2L);
        if (employee.isPresent()) {
            LOGGER.info("getById: " + employee.get());
        } else {
            LOGGER.info("getById: Entry not found");
        }

        LOGGER.info("Animal Dao:");
        IAnimalDao animalDao = RelationalRepositoriesFactory.createAnimalDao();
        Optional<Animal> animal = animalDao.getById(1L);
        if (animal.isPresent()) {
            LOGGER.info("getById: " + animal.get());
        } else {
            LOGGER.info("getById: Entry not found");
        }

        LOGGER.info("Department Dao:");
        IDepartmentDao departmentDao = RelationalRepositoriesFactory.createDepartmentDao();
        Optional<Department> department = departmentDao.getById(1L);
        if (department.isPresent()) {
            LOGGER.info("getById: " + department.get());
        } else {
            LOGGER.info("getById: Entry not found");
        }
    }

    private static void abstractFactory() {
        LOGGER.info("Employee Dao:");
        IEmployeeDao employeeDao = RepositoriesFactory.createEmployeeDao();
        Optional<Employee> employee = employeeDao.getById(2L);
        if (employee.isPresent()) {
            LOGGER.info("getById: " + employee.get());
        } else {
            LOGGER.info("getById: Entry not found");
        }

        LOGGER.info("Animal Dao:");
        IAnimalDao animalDao = RepositoriesFactory.createAnimalDao();
        Optional<Animal> animal = animalDao.getById(1L);
        if (animal.isPresent()) {
            LOGGER.info("getById: " + animal.get());
        } else {
            LOGGER.info("getById: Entry not found");
        }

        LOGGER.info("Department Dao:");
        IDepartmentDao departmentDao = RepositoriesFactory.createDepartmentDao();
        Optional<Department> department = departmentDao.getById(1L);
        if (department.isPresent()) {
            LOGGER.info("getById: " + department.get());
        } else {
            LOGGER.info("getById: Entry not found");
        }
    }

    private static void builder() {

        Mascot mascot = Mascot.builder()
                .name("Spike")
                .specie("Dog")
                .status("In a cage")
                .placeOfOrigin("Argentina")
                .age(3)
                .cageId(23)
                .tagId(54)
                .build();
        LOGGER.info(mascot);
    }
}
