package com.ground.inventory.database;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
//@ComponentScan(basePackageClasses = BeansPackageMarker.class, includeFilters = @ComponentScan.Filter(ConventionSucks.class))
public class Config {
	@Bean(name="helloBean")
    public HelloWorld helloWorld() {
        return new HelloWorldImpl();
    }
	
}
