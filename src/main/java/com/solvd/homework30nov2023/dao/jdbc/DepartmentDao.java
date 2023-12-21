package com.solvd.homework30nov2023.dao.jdbc;

import com.solvd.homework30nov2023.dao.IDepartmentDao;
import com.solvd.homework30nov2023.dao.Utils;
import com.solvd.homework30nov2023.model.ConnectionPool;
import com.solvd.homework30nov2023.model.Department;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DepartmentDao implements IDepartmentDao {

    ConnectionPool connectionPool = ConnectionPool.create();

    @Override
    public Department getById(int id) {
        Department department = new Department();
        Connection connection = connectionPool.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            preparedStatement = connection.prepareStatement(
                    "SELECT * FROM departments WHERE id = ?"
            );
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            while (resultSet.next()) {
                department.setId(resultSet.getInt("id"));
                department.setName(resultSet.getString("name"));
                department.setDescription(resultSet.getString("description"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            connectionPool.releaseConnection(connection);
            Utils.closeAll(resultSet, preparedStatement);
        }
        return department;
    }

    @Override
    public int insert(Department department) {
        Connection connection = connectionPool.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        int generatedKey = 0;
        try {
            preparedStatement = connection.prepareStatement(
                    "INSERT INTO departments " +
                            "(name, description) " +
                            "VALUES " +
                            "(?, ?)",
                    Statement.RETURN_GENERATED_KEYS
            );
            preparedStatement.setString(1, department.getName());
            preparedStatement.setString(2, department.getDescription());
            preparedStatement.execute();
            resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                generatedKey = resultSet.getInt(1);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            connectionPool.releaseConnection(connection);
            Utils.closeAll(resultSet, preparedStatement);
        }
        return generatedKey;
    }

    @Override
    public void update(Department department) {
        Connection connection = connectionPool.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(
                    "UPDATE departments SET " +
                            "name = ?, " +
                            "description = ? " +
                            "WHERE id = ?"
            );
            preparedStatement.setString(1, department.getName());
            preparedStatement.setString(2, department.getDescription());
            preparedStatement.setInt(3, department.getId());
            preparedStatement.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            connectionPool.releaseConnection(connection);
            Utils.closeAll(null, preparedStatement);
        }
    }

    @Override
    public void removeById(int id) {
        Connection connection = connectionPool.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(
                    "DELETE FROM departments " +
                            "WHERE id = ?"
            );
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            connectionPool.releaseConnection(connection);
            Utils.closeAll(null, preparedStatement);
        }
    }

    @Override
    public List<Department> getAll() {
        List<Department> list = new ArrayList<>();
        Connection connection = connectionPool.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            preparedStatement = connection.prepareStatement(
                    "SELECT * FROM departments"
            );
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            while (resultSet.next()) {
                Department department = new Department();
                department.setId(resultSet.getInt("id"));
                department.setName(resultSet.getString("name"));
                department.setDescription(resultSet.getString("description"));
                list.add(department);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            connectionPool.releaseConnection(connection);
            Utils.closeAll(resultSet, preparedStatement);
        }
        return list;
    }
}
