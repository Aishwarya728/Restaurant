package com.stackroute.restaurant.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.restaurant.controller.Restaurant;
import com.stackroute.restaurant.repository.RestaurantRepository;

@Service
public class RestaurantServiceDaoImpl implements RestaurantService{

		
		
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

		public RestaurantRepository getRestaurantRepository() {
			return restaurantRepository;
		}

		@Autowired
		public void setRestaurantRepository(RestaurantRepository restaurantRepository) {
			this.restaurantRepository = restaurantRepository;
		}

		public void delete(String id) {
			restaurantRepository.delete(id);
			
		}

	}
