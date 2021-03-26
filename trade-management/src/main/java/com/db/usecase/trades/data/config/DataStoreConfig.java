package com.db.usecase.trades.data.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class DataStoreConfig {

    @Bean (name = "trade_datasource")
    public DriverManagerDataSource getDataSource() {
        DriverManagerDataSource dataSourceBuilder = new DriverManagerDataSource();
        dataSourceBuilder.setUrl("jdbc:mysql://localhost:3306/trade_store");
        dataSourceBuilder.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSourceBuilder.setUsername("root");
        dataSourceBuilder.setPassword("root");
        return dataSourceBuilder;
    }

    @Bean
    public NamedParameterJdbcTemplate namedParameterJdbcTemplate (DataSource dataSource) {
        return new NamedParameterJdbcTemplate(dataSource);
    }

}
