package com.solvd.homework30nov2023.threads;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class ConnectionThread implements Runnable {

    ConnectionPool connectionPool;
    CopyOnWriteArrayList<String> register = new CopyOnWriteArrayList<>();

    public ConnectionThread(ConnectionPool connectionPool) {
        this.connectionPool = connectionPool;
    }

    @Override
    public void run() {
        MockConnection connection = connectionPool.getConnection();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        register.add(connection.readValue());
        connectionPool.releaseConnection(connection);
    }

    public String[] readValues() {
        return register.toArray(new String[0]);
    }
}
