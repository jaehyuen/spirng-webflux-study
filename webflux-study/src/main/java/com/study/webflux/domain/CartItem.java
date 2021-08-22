package com.study.webflux.domain;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CartItem {

	private final Item item;
	private final int quantity;
}
