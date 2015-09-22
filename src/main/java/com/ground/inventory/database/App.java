package com.ground.inventory.database;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
	public static void main(String[] args) {

		ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
		HelloWorld obj = (HelloWorld) context.getBean("helloBean");

		obj.printHelloWorld("Spring3 Java Config");

	}
}