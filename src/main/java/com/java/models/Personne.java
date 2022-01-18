package com.java.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@Entity
@Data @NoArgsConstructor @AllArgsConstructor @ToString
public class Personne {
	
	@Id@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@Column()
	 private String titre ;
	@Column()
	 private String prenom ;
	@Column()
	 private String nom ;
	@Column()
	 private String profession ;
	@Column()
	 private Date dateNaissance ;
	@Column()
	 private String nationalite ;
	@Column()
	 private String adresse ;
	@Column()
	 private String tel ;
	@Column(unique = true)
	private String email;
	@Column()
	private String password;
	@Column(unique = true)
	private String cin;
	@Column()
	private String typeCin;
	@Column()
	private String role;
}
