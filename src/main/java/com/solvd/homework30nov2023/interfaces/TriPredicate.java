package com.solvd.homework30nov2023.interfaces;

@FunctionalInterface
public interface TriPredicate<A, B, C> {
    boolean test(A x, B y, C z);
}