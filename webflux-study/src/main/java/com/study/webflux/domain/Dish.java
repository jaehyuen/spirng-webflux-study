package com.study.webflux.domain;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Dish {

	private final String description;
	private boolean      delivered = false;

	public static Dish deliver(Dish dish) {
		Dish deliveredDish = new Dish(dish.getDescription());
		deliveredDish.setDelivered(true);
		return deliveredDish;
	}

}
