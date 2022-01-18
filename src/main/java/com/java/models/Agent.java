package com.java.models;

import java.math.BigDecimal;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Table(name="agent")
@Entity
@Data @ToString @AllArgsConstructor @NoArgsConstructor
public class Agent extends Personne {


	private double soldeAgent;
	@ManyToOne
	@JoinColumn(name="ID_AGENCE") 
	private Pointdevente pointdevente;
	 
	
}
