package com.bank.client.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.bank.client.model.dao.Client;


@Repository
public interface ClientRepository extends ReactiveMongoRepository<Client, String>{
}
