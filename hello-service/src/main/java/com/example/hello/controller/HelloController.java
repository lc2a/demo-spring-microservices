package com.example.hello.controller;

import com.example.hello.domain.Hello;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
@RequestMapping("/api")
public class HelloController {

    @HystrixCommand(fallbackMethod = "fallbackSayHi")
    @GetMapping("/hello")
    public Hello sayHello() {
        randomlyRunLong();
        return new Hello(true, "Hello!!!");
    }

    public Hello fallbackSayHello() {
        return new Hello(false, "this is fallback method");
    }

    private void randomlyRunLong() {
        Random rand = new Random();
        int randomNum = rand.nextInt(3) + 1;
        if (randomNum == 3) sleep();
    }

    private void sleep() {
        try {
            Thread.sleep(11000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
