package com.thupq.mypets.configurations.security;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

@Configuration
@PropertySource({"classpath:application.yml"})
@EnableJpaRepositories(
        basePackages = "com.thupq.mypets.repository.transaction",
        entityManagerFactoryRef = "transactionEntityManager",
        transactionManagerRef = "transactionTransactionManager")
public class TransactionDatasourceConfiguration {
    @Bean
    @ConfigurationProperties(prefix="spring.second-datasource")
    public DataSource transactionDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean transactionEntityManager(
            EntityManagerFactoryBuilder builder, @Qualifier("transactionDataSource") DataSource dataSource) {
        return builder
                .dataSource(dataSource)
                .packages("com.thupq.mypets.models.entity.transaction")
                .persistenceUnit("transaction")
                .build();
    }

    @Bean
    public JpaTransactionManager transactionTransactionManager(
            @Qualifier("transactionEntityManager") EntityManagerFactory transactionEntityManager) {
        return new JpaTransactionManager(transactionEntityManager);
    }
}

