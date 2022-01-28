package com.java.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.java.models.Agent;
import com.java.models.Client;

@RepositoryRestResource
public interface ClientRepository extends JpaRepository<Client, Long> {
    public Client findClientById(Long id);


}
