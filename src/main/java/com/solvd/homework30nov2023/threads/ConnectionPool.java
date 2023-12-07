package com.solvd.homework30nov2023.threads;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class ConnectionPool {
    private static final Logger LOGGER = LogManager.getLogger(ConnectionPool.class);
    private static ConnectionPool instance;
    private static List<MockConnection> connectionPool;
    private static List<MockConnection> usedConnections = new ArrayList<>();
    private static int INITIAL_POOL_SIZE = 5;

    private ConnectionPool() {
        connectionPool = new ArrayList<>(INITIAL_POOL_SIZE);
        for (int i = 0; i < INITIAL_POOL_SIZE; i++)
            connectionPool.add(new MockConnection());
    }

    public static ConnectionPool create() {
        if (instance == null)
            instance = new ConnectionPool();
        return instance;
    }

    synchronized public MockConnection getConnection() {
        LOGGER.info(Thread.currentThread().getName() + " getting connection");
        if (connectionPool.isEmpty()) {
            try {
                LOGGER.info(Thread.currentThread().getName() + " waiting....");
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        MockConnection connection = connectionPool
                .remove(connectionPool.size() - 1);
        usedConnections.add(connection);
        LOGGER.info(Thread.currentThread().getName() + " got connection");
        return connection;
    }

    synchronized public boolean releaseConnection(MockConnection connection) {
        connectionPool.add(connection);
        notify();
        return usedConnections.remove(connection);
    }

    public int getSize() {
        return connectionPool.size() + usedConnections.size();
    }
}
