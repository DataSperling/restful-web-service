package com.example.demo;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/*
* @RestController handles GET requests for /greeting by instantiating a new instance
* of the Greeting class
 */
@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    /*
    * @GetMapping: Ensures that HTTP GET requests to /greeting map to greeting()
    * Java method
    * @RequestParam: binds the value of the query string parameter 'name' into
    * the 'name' parameter of greeting()
     */
    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name",
                             defaultValue = "World") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }
}
