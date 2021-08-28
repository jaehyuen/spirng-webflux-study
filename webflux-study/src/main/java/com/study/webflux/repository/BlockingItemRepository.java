package com.study.webflux.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.study.webflux.domain.Item;

public interface BlockingItemRepository extends ReactiveCrudRepository<Item, String>{

}
