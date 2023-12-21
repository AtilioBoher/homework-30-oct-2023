package com.solvd.homework30nov2023;

import com.solvd.homework30nov2023.dao.jdbc.EmployeeDao;
import com.solvd.homework30nov2023.model.Employee;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class Main {

    private static final Logger LOGGER = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        employeeTest();
    }

    private static void employeeTest() {
        EmployeeDao employeeDao = new EmployeeDao();

        Employee employee = new Employee(1, "Atilio", "Boher", "Tester", 1);

        employeeDao.update(employee);

        int generatedId = employeeDao.insert(employee);
        LOGGER.info("Generated Id: " + generatedId);

        employee = employeeDao.getById(1);
        LOGGER.info("getById: " + employee + "\n");

        List<Employee> employees = employeeDao.getAll();
        for (Employee e : employees) {
            LOGGER.info(e);
        }

        employeeDao.removeById(generatedId);

        employees = employeeDao.getAll();
        for (Employee e : employees) {
            LOGGER.info(e);
        }
    }
}
