package com.study.webflux.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.study.webflux.domain.Cart;

public interface CartRepository extends ReactiveCrudRepository<Cart, String>{

}
