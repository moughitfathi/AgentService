package com.java.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.java.enums.Status;
import com.java.models.Emission;
import com.java.models.Transfer;
import com.java.services.AgentService;
import com.java.services.TransfertService;

@RestController
public class AgentController {
	
	@Autowired
	private AgentService agentService;
	
	@Autowired
	private TransfertService transfertService;
	
	@PostMapping("/TransfertEmis")
	   @ResponseStatus(HttpStatus.CREATED)
	    public Emission emissionByAgent(@RequestBody Emission emission){
	       return agentService.emissionTransfert(emission);
	   }
	
	@GetMapping("/transfertsByStatus/{status}")
	public List<Transfer> consulterTransfertsBystatus(@PathVariable Status status){
		List<Transfer> listesTransfertsByStatus=agentService.TransfertsByStatus(status);
		return listesTransfertsByStatus;
	}
	
	@PostMapping("/servirTransfertEspece/{id}")
	   @ResponseStatus(HttpStatus.CREATED)
	    public void servirTransferEspece(@RequestBody Transfer transfert, @PathVariable Long id){
         
		agentService.servirTransfertEspece(transfert,id);

	
	}
	
	@PostMapping("/servirTransfertEspeceMult/{id}")
	   @ResponseStatus(HttpStatus.CREATED)
	    public void servirTransferEspeceMult(@RequestBody List<Transfer> listetransferts, @PathVariable Long id){
      
		agentService.servirTransfertEspeceMult(listetransferts, id);

	
	}
	
	
	@PostMapping("/servirTransfertDebitMult/{id}")
	   @ResponseStatus(HttpStatus.CREATED)
	    public void servirTransferDebit(@RequestBody Transfer transfer, @PathVariable Long id){
   
		agentService.servirTransfertDebit(transfer,id);

	
	}
	
	@PostMapping("/servirTransfertDebitMult/{id}")
	   @ResponseStatus(HttpStatus.CREATED)
	    public void servirTransferDebitMult(@RequestBody List<Transfer> listetransferts, @PathVariable Long id){
   
		agentService.servirTransfertMultDebit(listetransferts,id);

	
	}
	
	

}
