package com.java.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.java.models.Emission;
import com.java.services.EmissionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

public class EmissionController {
	@Autowired
	  private EmissionService emissionService ;

	   @PostMapping("/emissionByAgent")
	   @ResponseStatus(HttpStatus.CREATED)
	    public Emission emissionByAgent(@RequestBody Emission emission){
	       return emissionService.emissionByAgent(emission);
	   }
	    @PostMapping(path = "/emissionByGab")
	    @ResponseStatus(HttpStatus.CREATED)
	    public Emission emissionByGab(@RequestBody Emission emission){
	        return  emissionService.emissionByGab(emission);
	    }
}