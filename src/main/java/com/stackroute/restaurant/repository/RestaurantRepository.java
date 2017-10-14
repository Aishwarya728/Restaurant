package com.stackroute.restaurant.repository;

import org.springframework.data.repository.CrudRepository;

import com.stackroute.restaurant.controller.Restaurant;

public interface RestaurantRepository extends CrudRepository<Restaurant, String> {
	public Restaurant findByName(String name);
	
	public Restaurant findById(String id);
}
