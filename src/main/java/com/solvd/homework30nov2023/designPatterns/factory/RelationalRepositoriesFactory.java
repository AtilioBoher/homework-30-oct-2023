package com.solvd.homework30nov2023.designPatterns.factory;

import com.solvd.homework30nov2023.dao.IAnimalDao;
import com.solvd.homework30nov2023.dao.IDepartmentDao;
import com.solvd.homework30nov2023.dao.IEmployeeDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class RelationalRepositoriesFactory {
    private static final Logger LOGGER = LogManager.getLogger(RelationalRepositoriesFactory.class);
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
        switch (type) {
            case "JDBC":
                return new com.solvd.homework30nov2023.dao.jdbc.AnimalDao();
            case "MYBATIS":
                return new com.solvd.homework30nov2023.dao.mybatis.AnimalDao();
            default:
                RuntimeException error = new RuntimeException(errorMessage);
                LOGGER.error(error);
                throw error;
        }
    }

    public static IDepartmentDao createDepartmentDao() {
        switch (type) {
            case "JDBC":
                return new com.solvd.homework30nov2023.dao.jdbc.DepartmentDao();
            case "MYBATIS":
                return new com.solvd.homework30nov2023.dao.mybatis.DepartmentDao();
            default:
                RuntimeException error = new RuntimeException(errorMessage);
                LOGGER.error(error);
                throw error;
        }
    }

    public static IEmployeeDao createEmployeeDao() {
        switch (type) {
            case "JDBC":
                return new com.solvd.homework30nov2023.dao.jdbc.EmployeeDao();
            case "MYBATIS":
                return new com.solvd.homework30nov2023.dao.mybatis.EmployeeDao();
            default:
                RuntimeException error = new RuntimeException(errorMessage);
                LOGGER.error(error);
                throw error;
        }
    }
}
