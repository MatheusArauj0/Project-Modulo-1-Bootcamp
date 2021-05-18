package com.devsuperior.project.resources;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.project.entities.Client;
import com.devsuperior.project.repositories.ClientRepository;

@RestController
@RequestMapping(value = "/clients")
public class ClientResources {
	
	@Autowired
	ClientRepository clientRepository;
	
	@GetMapping
	public ResponseEntity<List<Client>> findAll() {
		List<Client> list = new ArrayList<>();
		list.add(new Client(1L, "Matheus", "169.301.967-11", 1500.00, Instant.now(),2));
		list.add(new Client(2L, "Junior", "100.331.967-11", 1500.00, Instant.now(),5));
		return ResponseEntity.ok().body(list);
	}

}
