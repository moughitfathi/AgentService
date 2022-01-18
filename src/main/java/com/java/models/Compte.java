package com.java.models;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor @ToString
public class Compte {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id ;
	
	@Column(unique = true,nullable = false)
	private int numero ;
	
	@Column(nullable = false)
	private BigDecimal solde ;
	
	@ManyToOne(fetch=FetchType.LAZY) 
	private Client client;

    @ManyToOne(fetch=FetchType.LAZY) 
    private Pointdevente pointdevente;
	 

}
