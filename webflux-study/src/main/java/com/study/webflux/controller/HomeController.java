package com.study.webflux.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.reactive.result.view.Rendering;

import com.study.webflux.domain.Cart;
import com.study.webflux.repository.CartRepository;
import com.study.webflux.repository.ItemRepository;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@Controller
@RequiredArgsConstructor
public class HomeController {

	private final CartRepository cartRepository;
	private final ItemRepository itemRepository;

	@GetMapping
	Mono<Rendering> home() { // <1>
		return Mono.just(Rendering.view("home.html") // <2>
				.modelAttribute("items", //
						this.itemRepository.findAll()) // <3>
				.modelAttribute("cart", //
						this.cartRepository.findById("My Cart") // <4>
								.defaultIfEmpty(new Cart("My Cart")))
				.build());
	}

}
