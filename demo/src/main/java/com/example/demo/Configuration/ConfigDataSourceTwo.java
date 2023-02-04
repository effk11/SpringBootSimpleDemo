package com.example.demo.Configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.example.demo.Dao.DaoTeacher.TeacherDao;
import com.example.demo.Entity.EntityTeacher.Teacher;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
	basePackageClasses = TeacherDao.class,
	entityManagerFactoryRef = "EntityManagerFactoryTwo",
	transactionManagerRef = "TransactionManagerTwo")

public class ConfigDataSourceTwo {
	
	@Bean("DataSourceTwo")
	@ConfigurationProperties("spring.datasource.two")
	public DataSource DataSourceTwo() {
		return DataSourceBuilder.create().build();
	}

	@Bean("EntityManagerFactoryTwo")
    public LocalContainerEntityManagerFactoryBean EntityManagerFactoryTwo(
    		@Qualifier("DataSourceTwo") DataSource DataSourceTwo,
    		EntityManagerFactoryBuilder builder) {
        return builder //
        .dataSource(DataSourceTwo) //
        .packages(Teacher.class) //
        .persistenceUnit("DSTwo") //
        .build();
    }

	@Bean("TransactionManagerTwo")
	public PlatformTransactionManager TransactionManagerTwo(
	        @Qualifier("EntityManagerFactoryTwo") LocalContainerEntityManagerFactoryBean EntityManagerFactoryTwo) {
	    return new JpaTransactionManager(EntityManagerFactoryTwo.getObject());
	}


}
