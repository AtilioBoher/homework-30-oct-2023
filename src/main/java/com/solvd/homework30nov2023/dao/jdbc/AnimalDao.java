package com.solvd.homework30nov2023.dao.jdbc;

import com.solvd.homework30nov2023.dao.IAnimalDao;
import com.solvd.homework30nov2023.model.Animal;
import com.solvd.homework30nov2023.model.ConnectionPool;
import com.solvd.homework30nov2023.model.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AnimalDao implements IAnimalDao {

    ConnectionPool connectionPool = ConnectionPool.create();

    @Override
    public Animal getById(int id) {
        Animal animal = new Animal();
        Connection connection = connectionPool.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            preparedStatement = connection.prepareStatement(
                    "SELECT * FROM animals WHERE id = ?"
            );
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            while (resultSet.next()) {
                animal.setId(resultSet.getInt("id"));
                animal.setName(resultSet.getString("name"));
                animal.setAge(resultSet.getInt("age"));
                animal.setSpecie(resultSet.getString("specie"));
                animal.setAttractionId(resultSet.getInt("attraction_id"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            connectionPool.releaseConnection(connection);
            closeAll(resultSet, preparedStatement);
        }
        return animal;
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
    public int insert(Animal animal) {
        Connection connection = connectionPool.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        int generatedKey = 0;
        try {
            preparedStatement = connection.prepareStatement(
                    "INSERT INTO animals " +
                            "(name, age, specie, attraction_id) " +
                            "VALUES " +
                            "(?, ?, ?, ?)",
                    Statement.RETURN_GENERATED_KEYS
            );
            preparedStatement.setString(1, animal.getName());
            preparedStatement.setInt(2, animal.getAge());
            preparedStatement.setString(3, animal.getSpecie());
            preparedStatement.setInt(4, animal.getAttractionId());
            preparedStatement.execute();
            resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                generatedKey = resultSet.getInt(1);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            connectionPool.releaseConnection(connection);
            closeAll(resultSet, preparedStatement);
        }
        return generatedKey;
    }

    @Override
    public void update(Animal animal) {
        Connection connection = connectionPool.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(
                    "UPDATE animals SET " +
                            "name = ?, " +
                            "age = ?, " +
                            "specie = ?, " +
                            "attraction_id = ? " +
                            "WHERE id = ?"
            );
            preparedStatement.setString(1, animal.getName());
            preparedStatement.setInt(2, animal.getAge());
            preparedStatement.setString(3, animal.getSpecie());
            preparedStatement.setInt(4, animal.getAttractionId());
            preparedStatement.setInt(5, animal.getId());
            preparedStatement.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            connectionPool.releaseConnection(connection);
            closeAll(null, preparedStatement);
        }
    }

    @Override
    public void removeById(int id) {
        Connection connection = connectionPool.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(
                    "DELETE FROM animals " +
                            "WHERE id = ?"
            );
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            connectionPool.releaseConnection(connection);
            closeAll(null, preparedStatement);
        }
    }

    @Override
    public List<Animal> getAll() {
        List<Animal> list = new ArrayList<>();
        Connection connection = connectionPool.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            preparedStatement = connection.prepareStatement(
                    "SELECT * FROM animals"
            );
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            while (resultSet.next()) {
                Animal animal = new Animal();
                animal.setId(resultSet.getInt("id"));
                animal.setName(resultSet.getString("name"));
                animal.setAge(resultSet.getInt("age"));
                animal.setSpecie(resultSet.getString("specie"));
                animal.setAttractionId(resultSet.getInt("attraction_id"));
                list.add(animal);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            connectionPool.releaseConnection(connection);
            closeAll(resultSet, preparedStatement);
        }
        return list;
    }
}
