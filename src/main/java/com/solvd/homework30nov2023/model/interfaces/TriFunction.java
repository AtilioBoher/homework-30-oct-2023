package com.solvd.homework30nov2023.model.interfaces;

@FunctionalInterface
public interface TriFunction<A, B, C, R> {
    R apply(A x, B y, C z);
}
