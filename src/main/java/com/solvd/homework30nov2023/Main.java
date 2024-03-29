package com.solvd.homework30nov2023;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static com.solvd.homework30nov2023.homework.DesignPatternsHomework.designPatternsHomework;
import static com.solvd.homework30nov2023.homework.MyBatisHomework.myBatisHomeTask;
import static com.solvd.homework30nov2023.homework.XmlParsingHomework.xmlParsingHomeTask;

public class Main {

    private static final Logger LOGGER = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
//        myBatisHomeTask();
//        xmlParsingHomeTask();
        designPatternsHomework();
    }
}
