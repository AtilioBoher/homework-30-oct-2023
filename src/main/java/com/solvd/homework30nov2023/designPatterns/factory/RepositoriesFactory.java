package com.solvd.homework30nov2023.designPatterns.factory;

import com.solvd.homework30nov2023.dao.IAnimalDao;
import com.solvd.homework30nov2023.dao.IDepartmentDao;
import com.solvd.homework30nov2023.dao.IEmployeeDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class RepositoriesFactory {
    private static final Logger LOGGER = LogManager.getLogger(RepositoriesFactory.class);
    private static final Properties p = new Properties();
    private static final String type;
    private static final String errorMessage;

    static {
        try (FileInputStream f = new FileInputStream("src/main/resources/db.properties")) {
            p.load(f);
        } catch (IOException e) {
            LOGGER.info(e);
        }
        type = p.getProperty("db.type");
        errorMessage = String.format("Unable to create database of type %s", type);
    }


    public static IAnimalDao createAnimalDao() {
        switch (type) {
            case "RELATIONAL":
                return RelationalRepositoriesFactory.createAnimalDao();
            case "NONRELATIONAL":
                return NonRelationalRepositoriesFactory.createAnimalDao();
            default:
                throw new RuntimeException(errorMessage);
        }
    }

    public static IDepartmentDao createDepartmentDao() {
        switch (type) {
            case "RELATIONAL":
                return RelationalRepositoriesFactory.createDepartmentDao();
            case "NONRELATIONAL":
                return NonRelationalRepositoriesFactory.createDepartmentDao();
            default:
                throw new RuntimeException(errorMessage);
        }
    }

    public static IEmployeeDao createEmployeeDao() {
        switch (type) {
            case "RELATIONAL":
                return RelationalRepositoriesFactory.createEmployeeDao();
            case "NONRELATIONAL":
                return NonRelationalRepositoriesFactory.createEmployeeDao();
            default:
                throw new RuntimeException(errorMessage);
        }
    }
}
