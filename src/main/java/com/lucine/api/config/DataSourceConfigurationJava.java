package com.lucine.api.config;

import javax.sql.DataSource;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

    @Configuration
    class DataSourceConfiguration {

        @Bean
        public DataSource getDataSource() {
            DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
            dataSourceBuilder.username(System.getenv("lucine_db_user"));
            dataSourceBuilder.password(System.getenv("lucine_db_password"));
            dataSourceBuilder.url(System.getenv("lucine_db_url"));

            return dataSourceBuilder.build();
        }
    }

