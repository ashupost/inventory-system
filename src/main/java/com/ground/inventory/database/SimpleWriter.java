package com.ground.inventory.database;

import org.springframework.stereotype.Component;

@Component
public class SimpleWriter {
 
  public void sayHello() {
    System.out.println("Hello Spring DI Component!");
  }
}