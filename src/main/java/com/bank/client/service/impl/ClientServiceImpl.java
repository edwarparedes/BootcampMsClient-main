package com.bank.client.service.impl;

import org.springframework.stereotype.Service;

import com.bank.client.model.dao.Client;
import com.bank.client.repository.ClientRepository;
import com.bank.client.service.ClientService;

import lombok.AllArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@AllArgsConstructor
@Service
public class ClientServiceImpl implements ClientService{
	
	private final ClientRepository clientRepo;

	@Override
	public Flux<Client> findAll() {
		return clientRepo.findAll();
	}

	@Override
	public Mono<Client> findById(String id) {
		return clientRepo.findById(id);
	}
	
	@Override
	public Mono<Client> save(Client client) {
		return clientRepo.save(client);
	}

	@Override
	public void delete(String id) {
		clientRepo.deleteById(id).subscribe();
	}

}
