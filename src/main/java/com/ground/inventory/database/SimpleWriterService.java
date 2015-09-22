package com.ground.inventory.database;

import org.springframework.stereotype.Service;

@Service
public class SimpleWriterService {
 
  public void sayHello() {
    System.out.println("Hello Spring DI service!");
  }
}