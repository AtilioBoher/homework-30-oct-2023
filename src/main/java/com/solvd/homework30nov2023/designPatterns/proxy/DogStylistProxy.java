package com.solvd.homework30nov2023.designPatterns.proxy;

import com.solvd.homework30nov2023.designPatterns.decorator.DogStylist;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * This is a simple Proxy class to make DogService available only if the customer
 * supplies some information to reach him in case we have problems with his dog.
 */
public class DogStylistProxy {
    private static final Logger LOGGER = LogManager.getLogger(DogStylistProxy.class);

    /**
     * Executes {@link com.solvd.homework30nov2023.designPatterns.decorator.DogStylist#serviceDog(boolean, boolean)} method,
     * but only if the user has supplied his contact information
     *
     * @param name
     * @param lastName
     * @param phoneNum
     * @param trim
     * @param perfume
     */
    public static void serviceDog(String name, String lastName, String phoneNum, boolean trim, boolean perfume) {
        try {
            dummyCustomerValidator(name, lastName, phoneNum);
        } catch (MissingCustomerInfoException e) {
            LOGGER.error(e);
            return;
        }
        DogStylist.serviceDog(true, true);
    }

    private static void dummyCustomerValidator(String name, String lastName, String phoneNum) throws MissingCustomerInfoException {
        if ("".equals(name)) {
            throw new MissingCustomerInfoException("Missing customer's name");
        }
        if ("".equals(lastName)) {
            throw new MissingCustomerInfoException("Missing customer's last name");
        }
        if ("".equals(phoneNum)) {
            throw new MissingCustomerInfoException("Missing customer's phone number");
        }

    }

}
