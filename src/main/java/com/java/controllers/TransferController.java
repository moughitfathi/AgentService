package com.java.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.java.models.Transfer;
import com.java.services.TransfertService;

import java.util.List;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/backoffice/transfer")
@AllArgsConstructor
public class TransferController {
	
	  public final TransfertService transferService;

	    @PostMapping(path="/cash/{soldAgent}")
	    @ResponseStatus(HttpStatus.CREATED)
	    public Transfer transferByAgent(@RequestBody Transfer transfer, @PathVariable double soldAgent) {
	        return transferService.transferEspeceAgent(transfer,soldAgent);
	    }
	    @PostMapping(path="/cash/multiple/{soldAgent}")
	    @ResponseStatus(HttpStatus.CREATED)
	    public List<Transfer> transferMultByAgent(@RequestBody List<Transfer> transfers, @PathVariable double soldAgent){
	        return transferService.transferEspeceAgentMult(transfers,soldAgent);
	    }

	    @PostMapping(path="/debit/{soldCompte}")
	    @ResponseStatus(HttpStatus.CREATED)
	    public Transfer transferDebAgent(@RequestBody Transfer transfer,@PathVariable double soldCompte) throws Exception {
	        return transferService.transferDebAgent(transfer,soldCompte);
	    }

	    @PostMapping(path="/debit/multiple/{soldCompte}")
	    @ResponseStatus(HttpStatus.CREATED)
	    public List<Transfer> transferDebMultAgent(@RequestBody List<Transfer> transfers,@PathVariable double soldCompte){
	        return transferService.transferDebitAgentMult(transfers,soldCompte);
	    }

	    @PutMapping(path = "/block/{id}")
	    @ResponseStatus(HttpStatus.ACCEPTED)
	    public Transfer blockTransfer(@PathVariable Long id){
	        return transferService.blockTransfer(id);
	    }

	    @PutMapping(path = "/deblock/{id}")
	    @ResponseStatus(HttpStatus.ACCEPTED)
	    public Transfer deblockTransfer(@PathVariable Long id){
	        return transferService.deblockTransfer(id);
	    }


	    @GetMapping(path = "/{clientSrc}")
	    @ResponseStatus(HttpStatus.OK)
	    public List<Transfer> transferByAgent(@PathVariable Long clientSrc){
	        return transferService.myTransfers(clientSrc);
	    }

}
