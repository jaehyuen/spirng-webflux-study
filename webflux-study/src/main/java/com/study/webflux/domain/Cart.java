package com.study.webflux.domain;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Cart {

	@Id
	private final String id;
	private final List<CartItem> cartItems;

	public Cart(String id) {
		this(id, new ArrayList<>());
	}
}
