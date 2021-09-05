package com.study.webflux.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.reactive.result.view.Rendering;

import com.study.webflux.domain.Cart;
import com.study.webflux.domain.CartItem;
import com.study.webflux.repository.CartRepository;
import com.study.webflux.repository.ItemRepository;
import com.study.webflux.service.CartService;

import reactor.core.publisher.Mono;

@Controller
public class HomeController {

	private ItemRepository itemRepository;
	private CartRepository cartRepository;
	private CartService cartService;

	public HomeController(ItemRepository itemRepository, // <2>
			CartRepository cartRepository, CartService cartService) {
		this.itemRepository = itemRepository;
		this.cartRepository = cartRepository;
		this.cartService = cartService;
	}

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

	@PostMapping("/add/{id}") // <1>
	Mono<String> addToCart(@PathVariable String id) { // <2>
		return this.cartService.addToCart("My Cart", id).thenReturn("redirect:/");
	}

}
