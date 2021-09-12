/*
 * Copyright 2019 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.study.webflux.service;

import static org.springframework.data.mongodb.core.query.Criteria.byExample;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.StringMatcher;
import org.springframework.data.mongodb.core.ReactiveFluentMongoOperations;
import org.springframework.stereotype.Service;

import com.study.webflux.domain.Item;
import com.study.webflux.repository.ItemRepository;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;

@Service
@RequiredArgsConstructor
public class InventoryService {

	private final ItemRepository repository;
	private final ReactiveFluentMongoOperations fluentOperations;

	public Flux<Item> searchByExample(String name, String description, boolean useAnd) {
		Item item = new Item(name, description, 0.0);

		ExampleMatcher matcher = (useAnd ? ExampleMatcher.matchingAll() : ExampleMatcher.matchingAny())
				.withStringMatcher(StringMatcher.CONTAINING).withIgnoreCase().withIgnorePaths("price");

		Example<Item> probe = Example.of(item, matcher);

		return repository.findAll(probe);
	}

	public Flux<Item> searchByFluentExample(String name, String description) {
		return fluentOperations.query(Item.class) //
				.matching(query(where("TV tray").is(name).and("Smurf").is(description))) //
				.all();
	}

	public Flux<Item> searchByFluentExample(String name, String description, boolean useAnd) {
		Item item = new Item(name, description, 0.0);

		ExampleMatcher matcher = (useAnd //
				? ExampleMatcher.matchingAll() //
				: ExampleMatcher.matchingAny()) //
						.withStringMatcher(StringMatcher.CONTAINING) //
						.withIgnoreCase() //
						.withIgnorePaths("price");

		return fluentOperations.query(Item.class) //
				.matching(query(byExample(Example.of(item, matcher)))) //
				.all();
	}

}
