package com.solvd.homework30nov2023.threads;

public class ConnectionThread implements Runnable {

    ConnectionPool connectionPool;

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
        connectionPool.releaseConnection(connection);
    }
}
