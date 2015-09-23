package com.ground.inventory.database;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ComponentScan("com.ground.inventory.database")
@EnableAspectJAutoProxy
@ImportResource("classpath:/spring-xml/spring-resource.xml")
public class Config {
	

	
}
