package com.bank.client.service;

import com.bank.client.model.dao.Client;

import com.bank.client.model.dao.Credit;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ClientService {
	public Flux<Client> findAll();
	public Mono<Client> findById(String id);
	public Mono<Client> save(Client client);
	public void delete(String id);

	Flux<Credit> getCredits(String id);
}