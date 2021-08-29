package com.study.webflux.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.study.webflux.domain.Item;

public interface ItemRepository extends ReactiveCrudRepository<Item, String>{

}
