package com.example.task.manager.configuration;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;


public class DataSourceConfiguration {

    public DataSource postgresDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl("jdbc:postgresql://localhost:5432/tasks_svs");
        dataSource.setUsername("postgres");
        dataSource.setPassword("password");
        return dataSource;
    }

}
