package com.solvd.homework30nov2023;

import com.solvd.homework30nov2023.dao.jdbc.EmployeeDao;
import com.solvd.homework30nov2023.model.Employee;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {

    private static final Logger LOGGER = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        EmployeeDao employeeDao = new EmployeeDao();
        Employee employee = employeeDao.getById(20);
        LOGGER.info(employee.getFirstName());
    }
}
