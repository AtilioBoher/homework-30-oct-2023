package com.solvd.homework30nov2023.interfaces;

@FunctionalInterface
public interface TriConsumer<A, B, C> {
    void accept(A x, B y, C z);
}
