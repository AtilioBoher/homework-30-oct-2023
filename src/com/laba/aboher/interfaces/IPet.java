package com.laba.aboher.interfaces;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public interface IPet {

    default void pet(Pettable pettable) {
        Logger logger = LogManager.getLogger(IPet.class);
        logger.info("I like to pet animals, I will pet this one");
        pettable.letHimSelfBePet();
    }
}
