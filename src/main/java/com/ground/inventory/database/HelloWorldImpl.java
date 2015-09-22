package com.ground.inventory.database;

public class HelloWorldImpl implements HelloWorld {

	@Override
	public void printHelloWorld(String msg) {

		System.out.println("Hello : " + msg);
	}

}