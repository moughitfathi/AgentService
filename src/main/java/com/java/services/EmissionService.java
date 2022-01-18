package com.java.services;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.java.models.Emission;

@FeignClient(name = "emission-service", url = "http://localhost:8083/")
public interface EmissionService {
	
	 @PostMapping("/emissionByAgent")
	 public Emission emissionByAgent(@RequestBody Emission emission);

	 @PostMapping(path = "/emissionByGab")
	 public Emission emissionByGab(@RequestBody Emission emission);

}
