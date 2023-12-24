package com.solvd.homework30nov2023.dao.jdbc;

import com.solvd.homework30nov2023.dao.IAnimalDao;
import com.solvd.homework30nov2023.dao.Utils;
import com.solvd.homework30nov2023.model.Animal;
import com.solvd.homework30nov2023.dao.ConnectionPool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AnimalDao implements IAnimalDao {

    ConnectionPool connectionPool = ConnectionPool.create();
    private static final Logger LOGGER = LogManager.getLogger(AnimalDao.class);

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
            LOGGER.error(e);
        } finally {
            connectionPool.releaseConnection(connection);
            Utils.closeAll(resultSet, preparedStatement);
        }
        return animal;
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
            LOGGER.error(e);
        } finally {
            connectionPool.releaseConnection(connection);
            Utils.closeAll(resultSet, preparedStatement);
        }
        return generatedKey;
    }

    @Override
    public void update(Animal animal, Long id) {
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
                    "DELETE FROM animals " +
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
            LOGGER.error(e);
        } finally {
            connectionPool.releaseConnection(connection);
            Utils.closeAll(resultSet, preparedStatement);
        }
        return list;
    }
}
