package com.laba.aboher.interfaces;

public interface IPet {

    default void pet(Pettable pettable) {
        System.out.println("I like to pet animals, I will pet this one");
        pettable.letHimSelfBePet();
    }
}
