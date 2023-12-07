package com.solvd.homework30nov2023.threads;

public class MockConnection {

    public String readValue() {
        return Thread.currentThread().getName();
    }
}
