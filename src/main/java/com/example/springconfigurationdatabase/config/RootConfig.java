package com.example.springconfigurationdatabase.config;


import com.zaxxer.hikari.HikariDataSource;
import jakarta.persistence.EntityManagerFactory;
import org.hibernate.jpa.HibernatePersistenceProvider;
import org.hibernate.jpa.boot.spi.EntityManagerFactoryBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@Configuration
@ComponentScan(value = "com.example.springconfigurationdatabase")
@PropertySource("classpath:application.properties")
@EnableJpaRepositories(value = "com.example.springconfigurationdatabase.repository")
public class RootConfig {
    @Value("${spring.datasource.url}")
    private String url;
    @Value("${spring.datasource.username}")
    private String username;
    @Value("${spring.datasource.password}")
    private String password;
    @Bean("entityManagerFactory")
    public LocalContainerEntityManagerFactoryBean createEntityManagerBean(){
        var emf = new LocalContainerEntityManagerFactoryBean();
        emf.setDataSource(createDataSource());
        emf.setPersistenceProviderClass(HibernatePersistenceProvider.class);
        emf.setPackagesToScan("com.example.springconfigurationdatabase.entity");
        emf.getJpaPropertyMap().put("hibernate.show_sql", true);
        emf.getJpaPropertyMap().put("hibernate.format_sql", true);
        return emf;
    }
    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
        return new JpaTransactionManager(emf);
    }

    @Bean
    public DataSource createDataSource(){
        var hikariDataSource = new HikariDataSource();
        hikariDataSource.setJdbcUrl(url);
        hikariDataSource.setUsername(username);
        hikariDataSource.setPassword(password);
        return hikariDataSource;
    }
}
