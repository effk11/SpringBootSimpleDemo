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

import com.example.demo.Dao.DaoStudent.StudentDao;
import com.example.demo.Entity.EntityStudent.Student;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
	basePackageClasses = StudentDao.class,
	entityManagerFactoryRef = "EntityManagerFactoryOne",
	transactionManagerRef = "TransactionManagerOne")

public class ConfigDataSourceOne {
	
	@Bean("DataSourceOne")
	@Primary
	@ConfigurationProperties("spring.datasource.one")
	public DataSource DataSourceOne() {
		return DataSourceBuilder.create().build();
	}

	@Bean("EntityManagerFactoryOne")
	@Primary
    public LocalContainerEntityManagerFactoryBean EntityManagerFactoryOne(
    		@Qualifier("DataSourceOne") DataSource DataSourceOne,
    		EntityManagerFactoryBuilder builder) {
        return builder //
        .dataSource(DataSourceOne) //
        .packages(Student.class) //
        .persistenceUnit("DSOne") //
        .build();
    }

	@Bean("TransactionManagerOne")
	@Primary
	public PlatformTransactionManager TransactionManagerOne(
	        @Qualifier("EntityManagerFactoryOne") LocalContainerEntityManagerFactoryBean EntityManagerFactoryOne) {
	    return new JpaTransactionManager(EntityManagerFactoryOne.getObject());
	}
	


}
