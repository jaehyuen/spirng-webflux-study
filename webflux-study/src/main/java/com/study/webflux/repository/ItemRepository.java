package com.study.webflux.repository;

import org.springframework.data.repository.CrudRepository;

import com.study.webflux.domain.Item;

public interface ItemRepository extends CrudRepository<Item, String>{

}
