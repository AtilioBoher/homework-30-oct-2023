package com.solvd.homework30nov2023.homework;

import com.solvd.homework30nov2023.dao.IAnimalDao;
import com.solvd.homework30nov2023.dao.IDepartmentDao;
import com.solvd.homework30nov2023.dao.IEmployeeDao;
import com.solvd.homework30nov2023.designPatterns.builder.Mascot;
import com.solvd.homework30nov2023.designPatterns.decorator.DogStylist;
import com.solvd.homework30nov2023.designPatterns.factory.RelationalRepositoriesFactory;
import com.solvd.homework30nov2023.designPatterns.factory.RepositoriesFactory;
import com.solvd.homework30nov2023.designPatterns.listener.AdministrativeListener;
import com.solvd.homework30nov2023.designPatterns.listener.AnimalListenersHolder;
import com.solvd.homework30nov2023.designPatterns.listener.VeterinaryListener;
import com.solvd.homework30nov2023.designPatterns.listener.Zoo;
import com.solvd.homework30nov2023.designPatterns.proxy.DogStylistProxy;
import com.solvd.homework30nov2023.designPatterns.strategy.AnimalRepository;
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
//        builder();
//        Listener();
        // TODO: Add Facade pattern
//        decorator();
        proxy();
//        strategy();
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

    private static void Listener() {
        Zoo zoo = new Zoo();
        AnimalListenersHolder.subscribe(new VeterinaryListener());
        AnimalListenersHolder.subscribe(new AdministrativeListener());
        Animal animal = new Animal();
        LOGGER.info("-------------------------Add animal----------------------------");
        zoo.addAnimal(animal);
        LOGGER.info("-------------------------Remove animal----------------------------");
        zoo.removeAnimal(animal);
    }

    private static void strategy() {
        AnimalRepository animalRepository = new AnimalRepository(); // is using JDBC by default
        LOGGER.info("-------------------------Using JDBC----------------------------");
        Optional<Animal> animal = animalRepository.getById(1L);
        if (animal.isPresent()) {
            LOGGER.info("getById: " + animal.get());
        } else {
            LOGGER.info("getById: Entry not found");
        }
        LOGGER.info("-------------------------Using My Batis----------------------------");
        animalRepository.useMyBatis();
        animal = animalRepository.getById(1L);
        if (animal.isPresent()) {
            LOGGER.info("getById: " + animal.get());
        } else {
            LOGGER.info("getById: Entry not found");
        }
    }

    private static void decorator() {
        DogStylist.serviceDog(true, true);
    }

    private static void proxy() {
        DogStylistProxy.serviceDog("John", "Doe", "1234-567891", true, true);
    }
}
