package com.java.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.java.models.Beneficiaire;

@RepositoryRestResource
public interface BeneficiareRepository extends JpaRepository<Beneficiaire, Long> {

}
