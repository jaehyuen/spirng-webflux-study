package com.study.webflux.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Component;

import com.study.webflux.domain.Item;

@Component
public class RepositoryDatabaseLoader {

	@Bean
	CommandLineRunner init(MongoOperations operations) {
		return args ->{
			operations.save(new Item("Alf larm clock",19.99));
			operations.save(new Item("Smurf TV tray",24.99));
		};
	}

}
