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

	@PostMapping("/add/{id}") // <1>
	Mono<String> addToCart(@PathVariable String id) { // <2>
		return this.cartRepository.findById("My Cart") //
				.defaultIfEmpty(new Cart("My Cart")) // <3>
				.flatMap(cart -> cart.getCartItems().stream() // <4>
						.filter(cartItem -> cartItem.getItem() //
								.getId().equals(id)) //
						.findAny() //
						.map(cartItem -> {
							cartItem.increment();
							return Mono.just(cart);
						}) //
						.orElseGet(() -> { // <5>
							return this.itemRepository.findById(id) //
									.map(item -> new CartItem(item)) //
									.map(cartItem -> {
										cart.getCartItems().add(cartItem);
										return cart;
									});
						}))
				.flatMap(cart -> this.cartRepository.save(cart)) // <6>
				.thenReturn("redirect:/"); // <7>
	}

}
