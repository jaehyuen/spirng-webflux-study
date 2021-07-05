package com.study.webflux.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.study.webflux.domain.Dish;
import com.study.webflux.service.KitchenSerivce;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;

@RestController
@RequiredArgsConstructor
public class ServcerController {

	 private final KitchenSerivce kitchen;
	 
	 @GetMapping(value = "server",produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	 public Flux<Dish> serveDishes(){
		 return this.kitchen.getDishes();
	 }
	
	
}
