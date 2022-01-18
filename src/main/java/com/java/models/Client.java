package com.java.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Table(name="client")
@Entity
@Data @NoArgsConstructor @AllArgsConstructor @ToString
public class Client extends Personne {
	
  
	
	@OneToMany(mappedBy = "client",fetch=FetchType.LAZY) 
	private List<Beneficiaire> beneficiaires;
	
	@OneToMany(mappedBy = "client",fetch=FetchType.LAZY,cascade =CascadeType.ALL)
	@JsonIgnore 
	private List<Compte> comptes;
}
