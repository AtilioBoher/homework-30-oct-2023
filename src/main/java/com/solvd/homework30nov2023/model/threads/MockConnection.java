package com.solvd.homework30nov2023.model.threads;

public class MockConnection {

    public String readValue() {
        return Thread.currentThread().getName();
    }
}
