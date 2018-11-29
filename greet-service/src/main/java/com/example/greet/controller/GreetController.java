package com.example.greet.controller;

import com.example.greet.service.ExternalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api")
public class GreetController {

    @Autowired
    private ExternalService externalService;

    @GetMapping("/hello")
    public String sayHello() {
        return externalService.sayHello();
    }

    @GetMapping("/hi")
    public String sayHi() {
        return externalService.sayHi();
    }

}
