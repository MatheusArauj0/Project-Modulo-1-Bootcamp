package com.devsuperior.project.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.project.dto.ClientDTO;
import com.devsuperior.project.entities.Client;
import com.devsuperior.project.repositories.ClientRepository;
import com.devsuperior.project.services.exceptions.ResourceNotFoundException;

@Service
public class ClientService {
	
	@Autowired
	private ClientRepository repository;
	
	@Transactional
	public List<ClientDTO> findAll(){
		List<Client> list =  repository.findAll();
		return list.stream().map(x -> new ClientDTO(x)).collect(Collectors.toList());
	}
	
	@Transactional
	public ClientDTO findById(Long id) {
		Optional<Client> obj = repository.findById(id);
		Client entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
		return new ClientDTO(entity);
	}
	
	@Transactional
	public ClientDTO insert(ClientDTO dto ) {
		Client client = new Client();
		copyDtoToEntity(dto, client);
		client = repository.save(client);
		return new ClientDTO(client);
	
	}
	
	
	private void copyDtoToEntity(ClientDTO dto, Client entity) {
		entity.setName(dto.getName());
		entity.setCpf(dto.getCpf());
		entity.setIncome(dto.getIncome());
		entity.setBirthDate(dto.getBirthDate());
		entity.setChildren(dto.getChildren());
	}

}
