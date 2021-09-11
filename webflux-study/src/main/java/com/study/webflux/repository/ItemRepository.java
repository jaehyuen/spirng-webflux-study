package com.study.webflux.repository;

import org.springframework.data.repository.query.ReactiveQueryByExampleExecutor;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.study.webflux.domain.Item;

import reactor.core.publisher.Flux;

public interface ItemRepository extends ReactiveCrudRepository<Item, String>, ReactiveQueryByExampleExecutor<Item> {
	Flux<Item> findByNameContaining(String partialName);

}
