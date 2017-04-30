package com.example.database;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.filter.CommonsRequestLoggingFilter;

import javax.servlet.Filter;
import javax.sql.DataSource;

/**
 * Created by tudor on 29/04/2017.
 */
@Configuration
public class Database {
	@Bean
	public DataSource mysqlDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("org.sqlite.JDBC");
		dataSource.setUrl("jdbc:sqlite:wsmt.db");
		dataSource.setUsername("");
		dataSource.setPassword("");
		
		return dataSource;
	}
	
	@Bean
	public Filter logFilter() {
		CommonsRequestLoggingFilter filter = new CommonsRequestLoggingFilter();
		filter.setIncludeQueryString(true);
		filter.setIncludePayload(true);
		filter.setMaxPayloadLength(5120);
		return filter;
	}
	
	@Bean
	public CarteRowMapper carteRowMapper() {
		return new CarteRowMapper();
	}
}
