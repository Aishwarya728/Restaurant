package com.stackroute.restaurant.controller;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.restaurant.repository.RestaurantRepository;

@Service
public class DummyService {
	
	@Autowired
	private RestaurantRepository restaurantRepository;
	
	public Iterable<Restaurant> getAll( )
	{
		return restaurantRepository.findAll();
	}
	
	public Restaurant getById(String id)
	{
		return restaurantRepository.findById(id);
	}
	
	public void add(Restaurant restaurant)
	{
		restaurantRepository.save(restaurant);
	}

	public void update(String id, Restaurant restaurant) {
		
		restaurantRepository.save(restaurant);
	}

	public void delete(String id) {
		restaurantRepository.delete(id);
		
	}
}
 