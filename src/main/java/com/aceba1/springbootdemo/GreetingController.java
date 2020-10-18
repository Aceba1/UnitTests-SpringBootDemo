package com.aceba1.springbootdemo;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

  private static final String template = "Hello, %s!";
  private final AtomicLong counter = new AtomicLong(); // Tasks run in parallel

  @GetMapping("/greeting") // Ensures hooked to /greeting path, will return a JSON-ified object
  public Greeting greeting(
    @RequestParam(value = "name", defaultValue = "World") String name
  ) {
    return new Greeting(
      counter.incrementAndGet(), // Get unique ID for new item
      String.format(template, name) // Pass parameter to item
    );
  }
}