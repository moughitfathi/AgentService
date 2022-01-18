package com.java.services;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.java.models.Transfer;

@FeignClient(name = "transfer-service" , url = "http://localhsot:8083/")
public interface TransfertService {
	

    @PostMapping(path="/cash/{soldAgent}")
    public Transfer transferEspeceAgent(@RequestBody Transfer transfer,@PathVariable double soldAgent);

    @PostMapping(path="/cash/multiple/{soldAgent}")
    public List<Transfer> transferEspeceAgentMult(@RequestBody List<Transfer> transfers, @PathVariable double soldAgent);

    @PostMapping(path="/debit/{soldCompte}")
    public Transfer transferDebAgent(@RequestBody Transfer transfer,@PathVariable double soldCompte);

    @PostMapping(path="/debit/multiple/{soldCompte}")
    public List<Transfer> transferDebitAgentMult(@RequestBody List<Transfer> transfers,@PathVariable double soldCompte);


    @PutMapping(path = "/block/{id}")
    public Transfer blockTransfer(@PathVariable Long id);

    @PutMapping(path = "/deblock/{id}")
    public Transfer deblockTransfer(@PathVariable Long id);

    @GetMapping(path = "/{clientSrc}")
    public List<Transfer> myTransfers(@PathVariable Long clientSrc);

    public List<Transfer> findTransferByexprDate(LocalDateTime exprDate);

    public List<Transfer> findByMotifBlocage(String motifBlocage);

}
