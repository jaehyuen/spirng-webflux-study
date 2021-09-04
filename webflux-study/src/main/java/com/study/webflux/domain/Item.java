package com.study.webflux.domain;

import org.springframework.data.annotation.Id;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Item {

	@Id
	private String id;
	private final String name;
	private final double price;
	
	
}
