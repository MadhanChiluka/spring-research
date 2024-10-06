package com.springjpa.muliple_db_connection_poc.config;

import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;


@Configuration
public class PostgresDataSourceConfiguration {

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.postgres")
    public DataSourceProperties postgresDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean
    public DataSource postgresDataSource() {
//        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//        dataSource.setUrl(postgresDataSourceProperties().getUrl());
//        dataSource.setUsername(postgresDataSourceProperties().getUsername());
//        dataSource.setPassword(postgresDataSourceProperties().getPassword());
//        return dataSource;
        return postgresDataSourceProperties().initializeDataSourceBuilder().build();
    }
}
