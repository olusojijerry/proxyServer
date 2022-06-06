package com.zenithbank.integration;

import com.zenithbank.integration.services.*;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
@EnableJpaRepositories(basePackages = "com.zenithbank.integration.repository")
@EntityScan({"com.zenithbank.integration.entity.flight"})
public class CoreFlightAutoConfiguration {
    @Bean
    @ConfigurationProperties("core.service.db")
    @ConditionalOnMissingBean
    public DataSource coreDataSource(){
        return new DriverManagerDataSource();
    }

    @Bean
    @ConditionalOnMissingBean
    public JdbcTemplate coreDataSourceJdbcTemplate(){
        return new JdbcTemplate(coreDataSource());
    }

    @Bean
    public CorePartnerService corePartnerService(){
        return new CorePartnerServiceImpl();
    }

    @Bean
    public CoreBookingDetailsService coreBookingDetailsService(){
        return new CoreBookingDetailsServiceImpl();
    }

    @Bean
    public CoreUserService coreUserService(){
        return new CoreUserServiceImpl();
    }


}
