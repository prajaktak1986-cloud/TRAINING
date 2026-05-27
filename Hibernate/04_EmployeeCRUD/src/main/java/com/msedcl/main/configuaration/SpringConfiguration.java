package com.msedcl.main.configuaration;

import java.sql.DriverManager;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class SpringConfiguration {
    
	public SpringConfiguration() {
		System.out.println("Deafult Constructor called - SpringConfiguration.");
		
	}
	
	@Bean 
	JdbcTemplate getJdbcTemplate() {
		
		System.out.println("called - getJdbcTemplate().");
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setUrl("jdbc:mysql://localhost:3306/hibernate_db");
		dataSource.setUsername("root");
		dataSource.setPassword("root123");
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");

		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		return jdbcTemplate;
	}
}
