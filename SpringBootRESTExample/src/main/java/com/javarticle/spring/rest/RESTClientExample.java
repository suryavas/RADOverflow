package com.javarticle.spring.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component("restClient")
public class RESTClientExample {
    @Autowired
    private RestTemplate restTemplate;

    public String getAllEmployees() {
        String response = restTemplate.getForObject("http://localhost:8080/pubmed/27177359", String.class);
        System.out.println("response = " + response);
        
        response = restTemplate.getForObject("http://localhost:8080/clinical/NCT00579215?term=lung cancer&rank=1", String.class);
        System.out.println("response = " + response);
        
        return null;
    }
}
