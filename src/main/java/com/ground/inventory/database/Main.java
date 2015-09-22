package com.ground.inventory.database;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

	@Autowired
	ComponentConsumer consumer; // <== Spring main class

	public Main() {
		ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
		AutowireCapableBeanFactory acbFactory = context.getAutowireCapableBeanFactory();
		acbFactory.autowireBean(this);
	}

	public static void main(String[] args) {

		Main main = new Main();
		main.consumer.consume();
	}
}