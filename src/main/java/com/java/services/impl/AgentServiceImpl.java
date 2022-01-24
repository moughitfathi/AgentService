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
import com.java.repositories.AgentRepository;
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
	private AgentRepository agentRepository;
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
	public void servirTransfertEspece(Transfer transfert, Long id) {
		Agent agent=agentRepository.findAgentById(id);
	
		Transfer tr=transfertService.transferEspeceAgent(transfert, agent.getSoldeAgent());
		
	}

	@Override
	public void servirTransfertEspeceMult(List<Transfer> listetransferts, Long id) {
		Agent agent=agentRepository.findAgentById(id);
		List<Transfer> listetr=transfertService.transferEspeceAgentMult(listetransferts, agent.getSoldeAgent());		
	}

	@Override
	public void servirTransfertDebit(Transfer transfert, Long id) {
		Agent agent=agentRepository.findAgentById(id);
		Transfer tr=transfertService.transferDebAgent(transfert, agent.getSoldeAgent());
	}

	@Override
	public void servirTransfertMultDebit(List<Transfer> listetransferts, Long id) {
		Agent agent=agentRepository.findAgentById(id);
		List<Transfer> listetr=transfertService.transferDebitAgentMult(listetransferts, agent.getSoldeAgent()) ;
		}
	
	

	
	


}
