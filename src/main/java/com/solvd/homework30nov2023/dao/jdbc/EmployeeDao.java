package com.solvd.homework30nov2023.dao.jdbc;

import com.solvd.homework30nov2023.dao.IEmployeeDao;
import com.solvd.homework30nov2023.model.ConnectionPool;
import com.solvd.homework30nov2023.model.Employee;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class EmployeeDao implements IEmployeeDao {

    ConnectionPool connectionPool = ConnectionPool.create();
    private static final Logger LOGGER = LogManager.getLogger(EmployeeDao.class);

    @Override
    public Employee getById(int id) {
        Employee employee = new Employee();
        Connection connection = connectionPool.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            preparedStatement = connection.prepareStatement(
                    "SELECT * FROM employees WHERE id = ?"
            );
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            while (resultSet.next()) {
                employee.setFirstName(resultSet.getString("first_name"));
                employee.setYearsOfExperience(resultSet.getInt("years_of_exp"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            connectionPool.releaseConnection(connection);
            closeAll(resultSet, preparedStatement);
        }
        return employee;
    }

    private void closeAll(ResultSet resultSet, PreparedStatement preparedStatement) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        if (preparedStatement != null) {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public void insert(Employee t) {

    }

    @Override
    public void update(Employee t) {

    }

    @Override
    public void remove(Employee t) {

    }

    @Override
    public List<Employee> getAll() {
        return null;
    }
}
