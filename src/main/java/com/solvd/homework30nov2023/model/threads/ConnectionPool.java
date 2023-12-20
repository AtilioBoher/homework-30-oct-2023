package com.solvd.homework30nov2023.model.threads;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class ConnectionPool {
    private static final Logger LOGGER = LogManager.getLogger(ConnectionPool.class);
    private static ConnectionPool instance;
    private static List<Connection> connectionPool;
    private static List<Connection> usedConnections = new ArrayList<>();
    private static int INITIAL_POOL_SIZE = 5;

    private ConnectionPool() {
        connectionPool = new ArrayList<>(INITIAL_POOL_SIZE);
        for (int i = 0; i < INITIAL_POOL_SIZE; i++)
            connectionPool.add(new Connection());
    }

    public static ConnectionPool create() {
        if (instance == null)
            instance = new ConnectionPool();
        return instance;
    }

    synchronized public Connection getConnection() {
        LOGGER.info(Thread.currentThread().getName() + " getting connection");
        if (connectionPool.isEmpty()) {
            try {
                LOGGER.info(Thread.currentThread().getName() + " waiting....");
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        Connection connection = connectionPool
                .remove(connectionPool.size() - 1);
        usedConnections.add(connection);
        LOGGER.info(Thread.currentThread().getName() + " got connection");
        return connection;
    }

    synchronized public boolean releaseConnection(Connection connection) {
        connectionPool.add(connection);
        notify();
        return usedConnections.remove(connection);
    }

    public int getSize() {
        return connectionPool.size() + usedConnections.size();
    }
}
