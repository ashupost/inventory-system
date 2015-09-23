package com.ground.inventory.database;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@ComponentScan("com.ground.inventory.database")
@EnableAspectJAutoProxy
@ImportResource("classpath:/spring-xml/spring-resource.xml")
@PropertySource("classpath:/properties/configuration.properties")
public class Config {

	@Autowired
	Environment env;

	@Bean
	public DriverManagerDataSource dataSource() {
		DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
		driverManagerDataSource.setDriverClassName("com.mysql.jdbc.Driver");
		driverManagerDataSource.setUrl("jdbc:mysql://127.0.0.1:3306/mhtsoft1_ground");
		driverManagerDataSource.setUsername("mhtsoft1_ground");
		driverManagerDataSource.setPassword("mhtsoft1_ground");

		System.out.println(env.getProperty("application.name"));

		return driverManagerDataSource;
	}

	@Bean
	public DataSourceTransactionManager transactionManager() {
		return new DataSourceTransactionManager(dataSource());
	}

}
