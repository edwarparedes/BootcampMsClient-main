package com.bank.client.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bank.client.model.dao.Client;
import com.bank.client.service.ClientService;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping("/client")
public class ClientController {
	
	private final ClientService clientService;

	@GetMapping
	public Flux<Client> getClients() {
		return clientService.findAll();
	}
	
	@GetMapping("/{id}")
	public Mono<Client> getClient(@PathVariable("id") String id) {
		return clientService.findById(id);
	}
	
	@PostMapping
	public Mono<Client> saveClient(@RequestBody Client client){
		return clientService.save(client);
	}
	
	@PutMapping
	public Mono<Client> updateClient(@RequestBody Client client){
		return clientService.save(client);
	}
	
	@DeleteMapping("/{id}")
	public void deleteClient(@PathVariable("id") String id) {
		clientService.delete(id);
	}
	
}
