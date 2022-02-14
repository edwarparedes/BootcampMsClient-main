package com.bank.client.service.impl;

import com.bank.client.model.dao.Credit;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;

import com.bank.client.model.dao.Client;
import com.bank.client.repository.ClientRepository;
import com.bank.client.service.ClientService;

import lombok.AllArgsConstructor;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@AllArgsConstructor
@Service
public class ClientServiceImpl implements ClientService{
	
	private final ClientRepository clientRepo;

	WebClient webClientCredit = WebClient.builder().baseUrl("http://localhost:8010").build();

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

	@Override
	public Flux<Credit> getCredits(String clientId) {
		Flux<Credit> creditFlux = webClientCredit
				.get()
				.uri("/credit/byClient/{clientId}", clientId)
				.accept(MediaType.APPLICATION_JSON)
				.retrieve()
				.bodyToFlux(Credit.class);
		return creditFlux;
	}

}
