package com.study.webflux.domain;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.geo.Point;

import lombok.Data;

@Data
public class Item {

	private @Id String id;
	private String name;
	private String description;
	private double price;
	private String distributorRegion;
	private Date releaseDate;
	private int availableUnits;
	private Point location;
	private boolean active;
	
	private Item() {}

	public Item(String name, String description, double price) {
		this.name = name;
		this.description = description;
		this.price = price;
	}

//
//	private Item() {
//	}
//
//	public Item(String name, double price) {
//		this.name = name;
//		this.price = price;
//	}
//	// end::code[]
//
//	public String getId() {
//		return id;
//	}
//
//	public void setId(String id) {
//		this.id = id;
//	}
//
//	public String getName() {
//		return name;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}
//
//	public double getPrice() {
//		return price;
//	}
//
//	public void setPrice(double price) {
//		this.price = price;
//	}

}
