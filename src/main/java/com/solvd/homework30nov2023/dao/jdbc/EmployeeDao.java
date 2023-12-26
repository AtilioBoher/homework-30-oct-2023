package com.solvd.homework30nov2023.dao.jdbc;

import com.solvd.homework30nov2023.dao.IEmployeeDao;
import com.solvd.homework30nov2023.model.Employee;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class EmployeeDao implements IEmployeeDao {

    ConnectionPool connectionPool = ConnectionPool.create();
    private static final Logger LOGGER = LogManager.getLogger(EmployeeDao.class);

    @Override
    public Optional<Employee> getById(Long id) {
        Employee employee = new Employee();
        Connection connection = connectionPool.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            preparedStatement = connection.prepareStatement(
                    "SELECT * FROM employees WHERE id = ?"
            );
            preparedStatement.setLong(1, id);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            while (resultSet.next()) {
                employee.setId(resultSet.getLong("id"));
                employee.setFirstName(resultSet.getString("first_name"));
                employee.setLastName(resultSet.getString("last_name"));
                employee.setPosition(resultSet.getString("position"));
                employee.setYearsOfExperience(resultSet.getInt("years_of_exp"));
            }
        } catch (SQLException e) {
            LOGGER.error(e);
        } finally {
            connectionPool.releaseConnection(connection);
            Utils.closeAll(resultSet, preparedStatement);
        }
        return Optional.of(employee);
    }

    @Override
    public Long insert(Employee employee) {
        Connection connection = connectionPool.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        long generatedKey = 0L;
        try {
            preparedStatement = connection.prepareStatement(
                    "INSERT INTO employees " +
                            "(first_name, last_name, position, years_of_exp) " +
                            "VALUES " +
                            "(?, ?, ?, ?)",
                    Statement.RETURN_GENERATED_KEYS
            );
            preparedStatement.setString(1, employee.getFirstName());
            preparedStatement.setString(2, employee.getLastName());
            preparedStatement.setString(3, employee.getPosition());
            preparedStatement.setInt(4, employee.getYearsOfExperience());
            preparedStatement.execute();
            resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                generatedKey = resultSet.getLong(1);
            }
        } catch (SQLException e) {
            LOGGER.error(e);
        } finally {
            connectionPool.releaseConnection(connection);
            Utils.closeAll(resultSet, preparedStatement);
        }
        return generatedKey;
    }

    @Override
    public void update(Employee employee, Long id) {
        Connection connection = connectionPool.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(
                    "UPDATE employees SET " +
                            "first_name = ?, " +
                            "last_name = ?, " +
                            "position = ?, " +
                            "years_of_exp = ? " +
                            "WHERE id = ?"
            );
            preparedStatement.setString(1, employee.getFirstName());
            preparedStatement.setString(2, employee.getLastName());
            preparedStatement.setString(3, employee.getPosition());
            preparedStatement.setInt(4, employee.getYearsOfExperience());
            preparedStatement.setLong(5, id);
            preparedStatement.execute();

        } catch (SQLException e) {
            LOGGER.error(e);
        } finally {
            connectionPool.releaseConnection(connection);
            Utils.closeAll(null, preparedStatement);
        }
    }

    @Override
    public void removeById(Long id) {
        Connection connection = connectionPool.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(
                    "DELETE FROM employees " +
                            "WHERE id = ?"
            );
            preparedStatement.setLong(1, id);
            preparedStatement.execute();
        } catch (SQLException e) {
            LOGGER.error(e);
        } finally {
            connectionPool.releaseConnection(connection);
            Utils.closeAll(null, preparedStatement);
        }
    }

    @Override
    public List<Employee> getAll() {
        List<Employee> list = new ArrayList<>();
        Connection connection = connectionPool.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            preparedStatement = connection.prepareStatement(
                    "SELECT * FROM employees"
            );
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            while (resultSet.next()) {
                Employee employee = new Employee();
                employee.setId(resultSet.getLong("id"));
                employee.setFirstName(resultSet.getString("first_name"));
                employee.setLastName(resultSet.getString("last_name"));
                employee.setPosition(resultSet.getString("position"));
                employee.setYearsOfExperience(resultSet.getInt("years_of_exp"));
                list.add(employee);
            }
        } catch (SQLException e) {
            LOGGER.error(e);
        } finally {
            connectionPool.releaseConnection(connection);
            Utils.closeAll(resultSet, preparedStatement);
        }
        return list;
    }
}
