package com.springdemo.springbootapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

// @Controller // To add this class to the container; works same as @Component, but we use @Controller in case of a controller
@RestController // In case of APIs; it is also a component which returns a reponse body
public class HelloController {

    // @RequestMapping(value = "/", method = RequestMethod.GET) // (Endpoint, HTTP Method)
    @GetMapping("/") // Same as above
    public String helloWorld(){
        return "Hello, World!";
    }
}
