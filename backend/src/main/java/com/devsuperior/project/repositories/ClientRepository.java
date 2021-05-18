package com.devsuperior.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devsuperior.project.entities.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

}
