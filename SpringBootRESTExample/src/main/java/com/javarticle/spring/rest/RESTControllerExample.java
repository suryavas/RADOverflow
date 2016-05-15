package com.javarticle.spring.rest;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class RESTControllerExample {
	@Autowired
    private RestTemplate restTemplate;
	
	
    @RequestMapping(value = "/pubmed/{id}", method = RequestMethod.GET)
    public String getPubMed(@PathParam("id") String id) {
    	
    	if (id != null) {
    		String response = restTemplate.getForObject("http://www.ncbi.nlm.nih.gov/pubmed/" + id, String.class);
    		System.out.println("getClinical id = " + id + "\tresponse = " + response);
    		return response;
    	}
    	return restTemplate.getForObject("http://www.ncbi.nlm.nih.gov/pubmed/27177359", String.class);

    }
    
    @RequestMapping(value = "/clinical/{id}", method = RequestMethod.GET)
    public String getClinical(@PathParam("id") String id, @RequestParam("term") String term, @RequestParam("rank") String rank) {
    	
    	if (term != null) {
    		String response = restTemplate.getForObject("https://clinicaltrials.gov/ct2/show/" + id + "?term=" + term + "&rank=" + rank, String.class);
    		System.out.println("getClinical id = " + term + "\tresponse = " + response);
    		return response;
    	}
    	return restTemplate.getForObject("https://clinicaltrials.gov/ct2/show/NCT00579215?term=lung+cancer&rank=1", String.class);

    }

}
