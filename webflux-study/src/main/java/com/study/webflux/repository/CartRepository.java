package com.study.webflux.repository;

import org.springframework.data.repository.CrudRepository;

import com.study.webflux.domain.Cart;

public interface CartRepository extends CrudRepository<Cart, String>{

}
