package com.ground.inventory.database;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ComponentConsumer {

	@Autowired
	private SimpleWriter component;
	
	@Autowired
	private SimpleWriterService service;

	@Autowired
	HelloWorld helloWorld;

	public void consume() {
		component.sayHello();
		service.sayHello();
		helloWorld.printHelloWorld("Workign");
	}
}