package com.java;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.java.models.Agent;
import com.java.models.Beneficiaire;
import com.java.models.Client;
import com.java.models.Compte;
import com.java.models.Personne;
import com.java.models.Pointdevente;
import com.java.repositories.BeneficiareRepository;
import com.java.repositories.ClientRepository;
import com.java.repositories.CompteRepository;
import com.java.repositories.PersonneRepository;
import com.java.repositories.PointdeventeRepository;

@SpringBootApplication
public class AgentServiceApplication implements CommandLineRunner {
	@Autowired private PersonneRepository personnerepository;
	@Autowired private CompteRepository compteRepository;
	@Autowired private ClientRepository clienRepository;
	@Autowired private BeneficiareRepository beneficiaireRepository;
	@Autowired private PointdeventeRepository pointdeventeRepository;

	public static void main(String[] args) {
		SpringApplication.run(AgentServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		

		Pointdevente pdv=new Pointdevente(null,"pdv1","casablanca","adresse","pdv@gmail.com","0625413578",null,null);
		
		
		
		Personne p1= new Personne(null, "Mr", "moughit", "fathi", "ingenieur",new Date(), "Marocaine",   "sakala","0629088113","abdelmoughit.fathi@gmail.com","password","N413923", "carte","agent");
		Personne p2= new Personne(null, "Mr","mt" ,"fi","ingenieur",new Date(),"Marocaine","sa","06489488164","abd.fathi@gmail.com","passwordd","N483927","carte","client");
		Compte c1=new Compte(null,1,new BigDecimal(35421),null,pdv);
		Beneficiaire b1=new Beneficiaire(null, "ben1", "benben", "password1", null);

		List<Compte> lc = new ArrayList<Compte>(); 
		List<Beneficiaire> lb = new ArrayList<Beneficiaire>(); 
		lc.add(c1); lb.add(b1); 		
		Client cl1= new Client(lb,lc);
		
		c1.setClient(cl1);
		b1.setClient(cl1);
		
		personnerepository.save(p1); 
		personnerepository.save(p2);
		pointdeventeRepository.save(pdv); 
		clienRepository.save(cl1);
		beneficiaireRepository.save(b1);
		compteRepository.save(c1);
		


	}
	
	

}
