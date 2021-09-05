//package com.study.webflux.service;
//
//import java.time.Duration;
//import java.util.Arrays;
//import java.util.List;
//import java.util.Random;
//
//import org.springframework.stereotype.Service;
//
//import com.study.webflux.domain.Dish;
//
//import reactor.core.publisher.Flux;
//
//@Service
//public class KitchenSerivce {
//
//	private List<Dish> menu   = Arrays.asList(new Dish("Sesame chicken"), new Dish("Lo mein noodles, plain"),
//			new Dish("Sweat & sour beef"));
//	private Random     picker = new Random();
//
//	public Flux<Dish> getDishes() {
//		return Flux.<Dish>generate(sink -> sink.next(randomDish()))
//			.delayElements(Duration.ofMillis(250));
//	}
//
//	private Dish randomDish() {
//		return menu.get(picker.nextInt(menu.size()));
//
//	}
//
//}
