package com.stackroute.restaurant.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.restaurant.controller.Restaurant;
import com.stackroute.restaurant.repository.RestaurantRepository;

public interface RestaurantService {
	
		public Iterable<Restaurant> getAll( );
		public Restaurant getById(String id);
		public void add(Restaurant restaurant);
		public void update(String id, Restaurant restaurant);
		public void delete(String id);
}
