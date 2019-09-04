package com.foxminded.university.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionFactory {
    private static final Logger log = LogManager.getLogger(ConnectionFactory.class);
    private static DataSource dataSource;

    static {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        dataSource = context.getBean("dataSource", DataSource.class);
        log.info("Datasource was created");
    }

    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }
}
