package com.solvd.homework30nov2023.dao.mybatis;

import com.solvd.homework30nov2023.Main;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;

public class PersistenceConfig {
    private static final Logger LOGGER = LogManager.getLogger(Main.class);
    private static final String configFile = "mybatis-config.xml";
    private static SqlSessionFactory sessionFactory;

    static {
        try (InputStream is = Resources.getResourceAsStream(configFile)) {
            sessionFactory = new SqlSessionFactoryBuilder()
                    .build(is);
        } catch (IOException e) {
            LOGGER.error(e);
        }
    }

    public static SqlSessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
