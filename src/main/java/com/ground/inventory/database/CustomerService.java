package com.ground.inventory.database;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class CustomerService
{
	String message;
	
	public void printMessage() {
		 System.out.println("Message is : " + message);
	}

	public void setMessage(String message) {
	  this.message = message;
	}
	
	@PostConstruct
	public void initIt() throws Exception {
	  System.out.println("Init method after properties are set : " + message);
	}
	
	@PreDestroy
	public void cleanUp() throws Exception {
	  System.out.println("Spring Container is destroy! Customer clean up");
	}
	
}