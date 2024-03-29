package com.solvd.homework30nov2023.designPatterns.factory;

import com.solvd.homework30nov2023.dao.IAnimalDao;
import com.solvd.homework30nov2023.dao.IDepartmentDao;
import com.solvd.homework30nov2023.dao.IEmployeeDao;
import com.solvd.homework30nov2023.dao.mongodb.AnimalDao;
import com.solvd.homework30nov2023.dao.mongodb.DepartmentDao;
import com.solvd.homework30nov2023.dao.mongodb.EmployeeDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class NonRelationalRepositoriesFactory {
    private static final Logger LOGGER = LogManager.getLogger(NonRelationalRepositoriesFactory.class);
    private static final Properties p = new Properties();
    private static final String type;
    private static final String errorMessage;

    static {
        try (FileInputStream f = new FileInputStream("src/main/resources/db.properties")) {
            p.load(f);
        } catch (IOException e) {
            LOGGER.info(e);
        }
        type = p.getProperty("db.implementation");
        errorMessage = String.format("Unable to create object of type %s", type);
    }

    public static IAnimalDao createAnimalDao() {
        if (type.equals("MONGODB")) {
            return new AnimalDao();
        }
        throw new RuntimeException(errorMessage);
    }

    public static IDepartmentDao createDepartmentDao() {
        if (type.equals("MONGODB")) {
            return new DepartmentDao();
        }
        throw new RuntimeException(errorMessage);
    }

    public static IEmployeeDao createEmployeeDao() {
        if (type.equals("MONGODB")) {
            return new EmployeeDao();
        }
        throw new RuntimeException(errorMessage);
    }
}
