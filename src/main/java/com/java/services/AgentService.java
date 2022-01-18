package com.java.services;

import java.util.List;


import com.java.enums.Status;
import com.java.models.Emission;
import com.java.models.Transfer;

public interface AgentService {
	
	 public Emission emissionTransfert(Emission emission);
	 
	 public List<Transfer> TransfertsByStatus(Status status);
	 
	 public void servirTransfertEspece(Transfer transfert);
	 public void servirTransfertEspeceMult(List<Transfer> transfert);
	 
	 public void servirTransfertDebit(Transfer transfert);
	 public void servirTransfertMultDebit(List<Transfer> transfert);



	
	

}
