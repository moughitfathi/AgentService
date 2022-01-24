package com.java.services;

import java.util.List;


import com.java.enums.Status;
import com.java.models.Emission;
import com.java.models.Transfer;

public interface AgentService {
	
	 public Emission emissionTransfert(Emission emission);
	 
	 public List<Transfer> TransfertsByStatus(Status status);
	 
	 public void servirTransfertEspece(Transfer transfert,Long id);
	 public void servirTransfertEspeceMult(List<Transfer> transfert, Long id);
	 
	 public void servirTransfertDebit(Transfer transfert,Long id);
	 public void servirTransfertMultDebit(List<Transfer> transfert,Long id);



	
	

}
