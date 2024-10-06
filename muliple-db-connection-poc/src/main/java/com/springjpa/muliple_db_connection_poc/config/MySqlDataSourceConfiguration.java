package com.springjpa.muliple_db_connection_poc.config;

import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class MySqlDataSourceConfiguration {

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.mysql")
    public DataSourceProperties mysqlDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean
    public DataSource mySqlDataSource() {
//        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//        dataSource.setUsername(mysqlDataSourceProperties().getUsername());
//        dataSource.setPassword(mysqlDataSourceProperties().getPassword());
//        dataSource.setUrl(mysqlDataSourceProperties().getUrl());
//        return dataSource;
        return mysqlDataSourceProperties().initializeDataSourceBuilder().build();
    }

//    @Bean(name = "mySqlDataSource")
//    @ConfigurationProperties(prefix = "spring.datasource.mysql")
//    public DataSource mySqlDataSource() {
//        return DataSourceBuilder.create().build();
//    }
}
