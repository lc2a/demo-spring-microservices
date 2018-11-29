package com.example.greet.service;

import com.example.greet.model.FallBack;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

@Service
public class ExternalServiceImpl implements ExternalService {

    @Autowired
    private ObjectMapper mapper;

    @Autowired
    RestTemplate restTemplate;

    @Override
    @HystrixCommand(fallbackMethod = "fallBackSayHello")
    public String sayHello() {
        String response = restTemplate.getForObject("http://hello-service/api/hello", String.class);
        return response;
    }

    @Override
    @HystrixCommand(fallbackMethod = "fallBackSayHi")
    public String sayHi() {
        String response = restTemplate.getForObject("http://hi-service/api/hi", String.class);
        return response;
    }

    public String fallBackSayHi() {
        FallBack fallback = new FallBack(false, "this is sayHi fallback");
        String json = "";
        try {
            json = mapper.writeValueAsString(fallback);
        } catch (Exception e) {
            e.getMessage();
        }
        return json;
    }

    public String fallBackSayHello() {
        FallBack fallback = new FallBack(false, "this is sayHello fallback");
        String json = "";
        try {
            json = mapper.writeValueAsString(fallback);
        } catch (Exception e) {
            e.getMessage();
            e.printStackTrace();
        }
        return json;
    }
}
