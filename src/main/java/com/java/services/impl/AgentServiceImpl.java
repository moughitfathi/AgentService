package com.java.services.impl;


import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.java.enums.Status;
import com.java.models.Agent;
import com.java.models.Emission;
import com.java.models.Transfer;
import com.java.services.AgentService;
import com.java.services.EmissionService;
import com.java.services.TransfertService;

@Service
@Transactional
public class AgentServiceImpl implements AgentService {
	
	@Autowired
	private EmissionService emissionService;
	@Autowired
	private AgentService agentService;
	
	@Autowired
	private TransfertService transfertService;

	@Override
	public Emission emissionTransfert(@RequestBody Emission emission) {
		return emissionService.emissionByAgent(emission);
	}

	@Override
	public List<Transfer> TransfertsByStatus(Status status) {
		List<Transfer> listesTransferts=transfertService.findTransfertByStatus();
		return listesTransferts;
		
	}

	@Override
	public void servirTransfertEspece(Transfer transfert) {
		Agent agent=agentService.getByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
	
		Transfer tr=transfertService.transferEspeceAgent(transfert, agent.getSoldeAgent());
		
	}

	@Override
	public void servirTransfertEspeceMult(List<Transfer> listetransferts) {
		Agent agent=agentService.getByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
		List<Transfer> listetr=transfertService.transferEspeceAgentMult(listetransferts, agent.getSoldeAgent());		
	}

	@Override
	public void servirTransfertDebit(Transfer transfert) {
		Agent agent=agentService.getByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
		Transfer tr=transfertService.transferDebAgent(transfert, agent.getSoldeAgent());
	}

	@Override
	public void servirTransfertEspeceMultDebit(List<Transfer> listetransferts) {
		Agent agent=agentService.getByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
		List<Transfer> listetr=transfertService.transferDebitAgentMult(listetransferts, agent.getSoldeAgent()) ;
		}
	
	

	
	


}
